/*
 * ====================================================================
 * JAFFA - Java Application Framework For All
 *
 * Copyright (C) 2002 JAFFA Development Group
 *
 *     This library is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public
 *     License as published by the Free Software Foundation; either
 *     version 2.1 of the License, or (at your option) any later version.
 *
 *     This library is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *     Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public
 *     License along with this library; if not, write to the Free Software
 *     Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * Redistribution and use of this software and associated documentation ("Software"),
 * with or without modification, are permitted provided that the following conditions are met:
 * 1.   Redistributions of source code must retain copyright statements and notices.
 *         Redistributions must also contain a copy of this document.
 * 2.   Redistributions in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 * 3.   The name "JAFFA" must not be used to endorse or promote products derived from
 *  this Software without prior written permission. For written permission,
 *  please contact mail to: jaffagroup@yahoo.com.
 * 4.   Products derived from this Software may not be called "JAFFA" nor may "JAFFA"
 *  appear in their names without prior written permission.
 * 5.   Due credit should be given to the JAFFA Project (http://jaffa.sourceforge.net).
 *
 * THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 */

package org.jaffa.modules.scheduler.services;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.apache.log4j.Logger;
import org.jaffa.modules.scheduler.services.configdomain.Config;
import org.jaffa.modules.scheduler.services.configdomain.Task;
import org.jaffa.util.JAXBHelper;
import org.jaffa.util.URLHelper;
import org.xml.sax.SAXException;

/**
 * This class implements the Singleton pattern. Use the getInstance() method to get an instance of this class.
 * The Configuration Service reads the 'resources/jaffa-scheduler-config.xml' file.
 * It provides methods to extract information from the configuration file.
 */
public class SchedulerConfiguration {

    private static final Logger log = Logger.getLogger(SchedulerConfiguration.class);

    /**
     * The location of the configuration file.
     */
    private static final String CONFIGURATION_FILE = "resources/jaffa-scheduler-config.xml";

    /**
     * The location of the schema for the configuration file.
     */
    private static final String CONFIGURATION_SCHEMA_FILE = "goldesp-scheduler-config_1_0.xsd";

    /**
     * The singleton instance of this class.
     */
    private static SchedulerConfiguration c_singleton;

    /**
     * Map of type and corresponding Task instance.
     */
    private static Map<String, Task> m_taskMap = new LinkedHashMap<String, Task>();

    /**
     * Map of dataBean class name and corresponding Task instance.
     */
    private static final Map<String, Task> m_taskByDataBeanMap = new LinkedHashMap<String, Task>();

    /**
     * Creates an instance of SchedulerConfiguration, if not already instantiated.
     *
     * @return An instance of the SchedulerConfiguration.
     */
    public static SchedulerConfiguration getInstance() {
        if (c_singleton == null)
            createSchedulerConfigurationInstance();
        return c_singleton;
    }

    /**
     * Returns the Java representation of the Task configuration.
     *
     * @return the Java representation of the Task configuration.
     */
    public String[] getTaskTypes() {
        return m_taskMap.keySet().toArray(new String[m_taskMap.size()]);
    }

    /**
     * Returns the Java representation of the Task configuration for the given type.
     *
     * @param type the task type.
     * @return the Java representation of the Task configuration for the given type.
     */
    public Task getTask(String type) {
        return m_taskMap.get(type);
    }

    /**
     * Returns the Java representation of the Task configuration for the given dataBean.
     *
     * @param dataBeanClassName the class name of the dataBean.
     * @return the Java representation of the Task configuration for the given dataBean.
     * @throws ClassNotFoundException if dataBeanClassName is not found on the classpath
     */
    public Task getTaskByDataBean(String dataBeanClassName) throws ClassNotFoundException {
        Task task = m_taskByDataBeanMap.get(dataBeanClassName);
        if (task == null && !m_taskByDataBeanMap.containsKey(dataBeanClassName)) {
            // Lookup the class hierarchy. Add a NULL for the dataBeanClassName, even if a Task is not found
            synchronized (m_taskByDataBeanMap) {
                task = m_taskByDataBeanMap.get(dataBeanClassName);
                if (task == null && !m_taskByDataBeanMap.containsKey(dataBeanClassName)) {
                    Class clazz = Class.forName(dataBeanClassName);
                    while (clazz.getSuperclass() != null) {
                        clazz = clazz.getSuperclass();
                        task = m_taskByDataBeanMap.get(clazz.getName());
                        if (task != null)
                            break;
                    }
                    m_taskByDataBeanMap.put(dataBeanClassName, task);
                }
            }
        }
        return task;
    }

    /**
     * Returns the Java representation of the Task configuration for the given type.
     *
     * @return the Java representation of the Task configuration for the given type.
     */
    public Task[] getTasks() {
        return m_taskMap.values().toArray(new Task[m_taskMap.size()]);
    }

    private static synchronized void createSchedulerConfigurationInstance() {
        if (c_singleton == null) {
            c_singleton = new SchedulerConfiguration();
            if (log.isDebugEnabled())
                log.debug("An instance of the SchedulerConfiguration has been created");
        }
    }

    private SchedulerConfiguration() {
        try {
            if (log.isDebugEnabled())
                log.debug("Unmarshalling the configuration file " + CONFIGURATION_FILE);
            URL configFileUrl = URLHelper.newExtendedURL(CONFIGURATION_FILE);
            URL configSchemaFileUrl = URLHelper.newExtendedURL(CONFIGURATION_SCHEMA_FILE);
            JAXBContext jc = JAXBHelper.obtainJAXBContext(Config.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(configSchemaFileUrl);
            unmarshaller.setSchema(schema);
            final Config m_config = (Config) unmarshaller.unmarshal(configFileUrl);

            // Creates a Map of type and corresponding Task instance
            if (m_config.getTask() != null) {
                for (Task task : m_config.getTask()) {
                    m_taskMap.put(task.getType(), task);
                    m_taskByDataBeanMap.put(task.getDataBean(), task);
                    if (log.isDebugEnabled())
                        log.debug("Loaded Task for " + task.getType());
                }
            }
        } catch (JAXBException e) {
            String s = "Error in parsing the configuration file " + CONFIGURATION_FILE;
            log.fatal(s, e);
            throw new RuntimeException(s, e);
        } catch (MalformedURLException e) {
            String s = "Error in locating the configuration file " + CONFIGURATION_FILE;
            log.fatal(s, e);
            throw new RuntimeException(s, e);
        } catch (SAXException e) {
            String s = "Error in loading the schema for the configuration file " + CONFIGURATION_SCHEMA_FILE;
            log.fatal(s, e);
            throw new RuntimeException(s, e);
        }
    }
}
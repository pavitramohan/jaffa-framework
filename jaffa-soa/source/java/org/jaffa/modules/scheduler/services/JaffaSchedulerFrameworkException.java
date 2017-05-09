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

import org.jaffa.exceptions.FrameworkException;

/** This FrameworkException will be thrown by the JaffaScheduler module for various internal error conditions.
 */
public class JaffaSchedulerFrameworkException extends FrameworkException {
    
    private static final String BASE_CODE = "exception.org.jaffa.modules.scheduler.services.JaffaSchedulerFrameworkException.";
    
    public static final String ACTIVATE_TASK_ERROR = BASE_CODE + "activateTaskError";
    public static final String ADD_TASK_ERROR = BASE_CODE + "addTaskError";
    public static final String DATA_BEAN_CREATION_ERROR = BASE_CODE + "dataBeanCreationError";
    public static final String DATA_BEAN_NOT_FOUND = BASE_CODE + "dataBeanNotFound";
    public static final String DELETE_TASK_ERROR = BASE_CODE + "deleteTaskError";
    public static final String INACTIVATE_TASK_ERROR = BASE_CODE + "inactivateTaskError";
    public static final String INITIAL_CONTEXT_ERROR = BASE_CODE + "initialContextError";
    public static final String MARSHALLING_ERROR = BASE_CODE + "marshallingError";
    public static final String MISSING_BUSINESS_OBJECT = BASE_CODE + "missingBusinessObject";
    public static final String MISSING_TASK_FOR_DATA_BEAN = BASE_CODE + "missingTaskForDataBean";
    public static final String PAUSE_SCHEDULER_ERROR = BASE_CODE + "pauseSchedulerError";
    public static final String SCHEDULER_SERVICE_NOT_FOUND = BASE_CODE + "schedulerServiceNotFound";
    public static final String START_SCHEDULER_ERROR = BASE_CODE + "startSchedulerError";
    public static final String STOP_SCHEDULER_ERROR = BASE_CODE + "stopSchedulerError";
    public static final String TASK_RETRIEVE_ERROR = BASE_CODE + "taskRetrieveError";
    public static final String UNMARSHALLING_ERROR = BASE_CODE + "unmarshallingError";
    
    
    /** Constructs a new Exception.
     * @param errorCode the errorCode.
     */
    public JaffaSchedulerFrameworkException(String errorCode) {
        this(errorCode, null);
    }
    
    /** Constructs a new Exception.
     * @param errorCode the errorCode.
     * @param arguments the arguments, if any, that need to be merged into the error message from the resource bundle.
     */
    public JaffaSchedulerFrameworkException(String errorCode, Object[] arguments) {
        this(errorCode, arguments, null);
    }
    
    /** Constructs a new Exception.
     * @param errorCode the errorCode.
     * @param arguments the arguments, if any, that need to be merged into the error message from the resource bundle.
     * @param cause the cause.
     */
    public JaffaSchedulerFrameworkException(String errorCode, Object[] arguments, Throwable cause) {
        super(errorCode, arguments);
    }
    
}

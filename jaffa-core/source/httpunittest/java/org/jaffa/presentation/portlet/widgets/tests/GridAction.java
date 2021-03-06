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
 * 1.	Redistributions of source code must retain copyright statements and notices.
 *         Redistributions must also contain a copy of this document.
 * 2.	Redistributions in binary form must reproduce the above copyright notice,
 * 	this list of conditions and the following disclaimer in the documentation
 * 	and/or other materials provided with the distribution.
 * 3.	The name "JAFFA" must not be used to endorse or promote products derived from
 * 	this Software without prior written permission. For written permission,
 * 	please contact mail to: jaffagroup@yahoo.com.
 * 4.	Products derived from this Software may not be called "JAFFA" nor may "JAFFA"
 * 	appear in their names without prior written permission.
 * 5.	Due credit should be given to the JAFFA Project (http://jaffa.sourceforge.net).
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

package org.jaffa.presentation.portlet.widgets.tests;

import org.jaffa.presentation.portlet.ActionBase;
import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.log4j.Logger;
import org.jaffa.presentation.portlet.FormKey;
import org.jaffa.presentation.portlet.session.UserSession;

/**
 *
 * @author  GautamJ
 * @version
 */
public class GridAction extends ActionBase {

    private static Logger log = Logger.getLogger(GridAction.class);

    public FormKey do_Model1_Validate(String rowNum, String fieldName)
    throws IOException, ServletException {
        if (log.isDebugEnabled())
            log.debug("Executing the method 'do_Model1_Validate'"
            + " with rowNum=" + rowNum
            + " and fieldName=" + fieldName);
            GridForm myForm = (GridForm) form;
            GridComponent myComp = (GridComponent) myForm.getComponent();
        // just return to the same screen
        return new FormKey(GridForm.NAME, component != null ? component.getComponentId() : null);
    }
    
//    can also use the following method
//    public FormKey do_Model1__Field1_Validate(String rowNum) {
//    }



    public FormKey do_Model1_Clicked(String rowNum)
    throws IOException, ServletException {
        if (log.isDebugEnabled())
            log.debug("Executing the method 'do_Model1_Clicked'"
            + " with rowNum=" + rowNum);
        // just return to the same screen
        return new FormKey(GridForm.NAME, component != null ? component.getComponentId() : null);
    }


    public FormKey do_Model1_Clicked(String rowNum, String fieldName)
    throws IOException, ServletException {
        if (log.isDebugEnabled())
            log.debug("Executing the method 'do_Model1_Clicked'"
            + " with rowNum=" + rowNum
            + " and fieldName=" + fieldName);

        // just return to the same screen
        return new FormKey(GridForm.NAME, component != null ? component.getComponentId() : null);
    }
    
    public FormKey do_Model2_Clicked(String rowNum)
    throws IOException, ServletException {
        if (log.isDebugEnabled())
            log.debug("Executing the method 'do_Model2_Clicked'"
            + " with rowNum=" + rowNum);
        // just return to the same screen
        return new FormKey(GridForm.NAME, component != null ? component.getComponentId() : null);
    }


    public FormKey do_Model2_Clicked(String rowNum, String fieldName)
    throws IOException, ServletException {
        if (log.isDebugEnabled())
            log.debug("Executing the method 'do_Model2_Clicked'"
            + " with rowNum=" + rowNum
            + " and fieldName=" + fieldName);

        // just return to the same screen
        return new FormKey(GridForm.NAME, component != null ? component.getComponentId() : null);
    }
    
    public FormKey do_Model3_Clicked(String rowNum)
    throws IOException, ServletException {
        if (log.isDebugEnabled())
            log.debug("Executing the method 'do_Model3_Clicked'"
            + " with rowNum=" + rowNum);
        // just return to the same screen
        return new FormKey(GridForm.NAME, component != null ? component.getComponentId() : null);
    }


    public FormKey do_Model3_Clicked(String rowNum, String fieldName)
    throws IOException, ServletException {
        if (log.isDebugEnabled())
            log.debug("Executing the method 'do_Model3_Clicked'"
            + " with rowNum=" + rowNum
            + " and fieldName=" + fieldName);

        // just return to the same screen
        return new FormKey(GridForm.NAME, component != null ? component.getComponentId() : null);
    }    
   
    
   /* public FormKey do_Model1_GetChildren(String rowNum, String fieldName)
    throws IOException, ServletException {
        if (log.isDebugEnabled())
            log.debug("Executing the method 'do_Model1_GetChildren'"
            + " with rowNum=" + rowNum
            + " and fieldName=" + fieldName);
            GridForm myForm = (GridForm) form;
            GridComponent myComp = (GridComponent) myForm.getComponent();
            myComp.getGridChildren(rowNum , fieldName , myForm);
            
            // just return to the same screen
            return new FormKey(GridForm.NAME, component != null ? component.getComponentId() : null);
    }*/

    // This method will supercede the above generic 'do_Model1_Clicked' method
    public FormKey do_Model1_Butt1_Clicked(String rowNum)
    throws IOException, ServletException {
        if (log.isDebugEnabled())
            log.debug("Executing the method 'do_Model1_Butt1_Clicked'"
            + " with rowNum=" + rowNum );

        // just return to the same screen
        return new FormKey(GridForm.NAME, component != null ? component.getComponentId() : null);
    }
    
    public FormKey do_Model2_Butt1_Clicked(String rowNum)
    throws IOException, ServletException {
        if (log.isDebugEnabled())
            log.debug("Executing the method 'do_Model2_Butt1_Clicked'"
            + " with rowNum=" + rowNum );

        // just return to the same screen
        return new FormKey(GridForm.NAME, component != null ? component.getComponentId() : null);
    }
        
    public FormKey do_Model3_Butt1_Clicked(String rowNum)
    throws IOException, ServletException {
        if (log.isDebugEnabled())
            log.debug("Executing the method 'do_Model3_Butt1_Clicked'"
            + " with rowNum=" + rowNum );

        // just return to the same screen
        return new FormKey(GridForm.NAME, component != null ? component.getComponentId() : null);
    }

        public FormKey do_Model2_GetChildren(String rowNum)
    throws IOException, ServletException {
        if (log.isDebugEnabled())
            log.debug("Executing the method 'do_Model1_Clicked'"
            + " with rowNum=" + rowNum);
            GridForm myForm = (GridForm) form;
            GridComponent myComp = (GridComponent) myForm.getComponent();
            myComp.getGridChildren(rowNum , "model2" , myForm);
        // just return to the same screen
        return new FormKey(GridForm.NAME, component != null ? component.getComponentId() : null);
    }
    
    public FormKey do_Model3_GetChildren(String rowNum)
    throws IOException, ServletException {
        if (log.isDebugEnabled())
            log.debug("Executing the method 'do_Model1_Clicked'"
            + " with rowNum=" + rowNum);
            GridForm myForm = (GridForm) form;
            GridComponent myComp = (GridComponent) myForm.getComponent();
            myComp.getGridChildren(rowNum , "model3" , myForm);
        // just return to the same screen
        return new FormKey(GridForm.NAME, component != null ? component.getComponentId() : null);
    }

    
    public FormKey do_Quit_Clicked() {
        if (log.isDebugEnabled())
            log.debug("Executing the method 'do_Quit_Clicked'");

        component.quit();
        return null;
    }

    public FormKey do_Post_Clicked() {
        if (log.isDebugEnabled())
            log.debug("Executing the method 'do_Post_Clicked'");

        // just return to the same screen
        return new FormKey(GridForm.NAME, component != null ? component.getComponentId() : null);
    }

}

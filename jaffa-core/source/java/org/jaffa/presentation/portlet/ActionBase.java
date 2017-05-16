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

/* Generated by Together */

package org.jaffa.presentation.portlet;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.Globals;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletException;
import org.jaffa.presentation.portlet.FormBase;
import org.jaffa.util.EventHandler;
import org.apache.log4j.Logger;
import java.lang.reflect.Method;
import org.jaffa.presentation.portlet.session.UserSession;
import org.jaffa.presentation.portlet.widgets.taglib.FormTag;
import org.jaffa.presentation.portlet.component.Component;
import javax.servlet.http.HttpSession;
import org.jaffa.datatypes.Parser;
import org.jaffa.config.Config;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.jaffa.presentation.portlet.FormKeyChangeEvent;
import org.jaffa.presentation.portlet.FormKeyChangeListener;
import org.jaffa.exceptions.ApplicationExceptions;
import org.jaffa.exceptions.TokenMismatchException;

/** This is the base class for all 'Action' classes
 */
public class ActionBase extends Action {

    private static Logger log = Logger.getLogger(ActionBase.class);
    private static final String NAME = "NAME";
    private static final String AJAX_FORWARD = "ajaxForward";

    /** The ActionMapping used to select this instance
     */
    protected ActionMapping mapping = null;
    /** The optional ActionForm bean for this request (if any)
     */
    protected ActionForm form = null;
    /** The HTTP request we are processing
     */
    protected HttpServletRequest request = null;
    /** The HTTP response we are creating
     */
    protected HttpServletResponse response = null;
    /** The optional component for this request (if any)
     */
    protected Component component = null;

    /**
     * Check the eventId & invoke the suitable method which will return the FormKey.
     * It will invoke the defaultAction() method in case the eventId is null.
     * This will throw the EventHandlerMissingRuntimeException in case no method is found.
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     * @throws Exception if the application business logic throws an exception
     * @return An ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response)
    throws Exception {
        // NOTE: Struts has implemented a singleton pattern for each Action class.
        // But we need to set instance variables on the Action class.
        // To get around Struts, we'll create a new instance of the Action class and invoke methods on that instance.
        ActionBase actionInstance = (ActionBase) this.getClass().newInstance();

        // ******************* VERY IMPORTANT NOTE ***************************
        // Invoke methods on 'actionInstance', rather than 'this'
        // ******************* VERY IMPORTANT NOTE ***************************

        actionInstance.mapping = mapping;
        actionInstance.form = form;
        actionInstance.request = request;
        actionInstance.response = response;

        FormKey fk = null;
        String eventId = null;
        FormBase formBase = null;

        // Get the eventId
        eventId = request.getParameter(FormTag.PARAMETER_EVENT_ID);
        String ajaxForward = request.getParameter(AJAX_FORWARD);

        // set the component
        if (form != null) {
            formBase = (FormBase) form;
            actionInstance.component = formBase.getComponent();
        }


        // invoke the defaultAction or the eventHandler
        if (eventId == null || eventId.length() == 0)
            fk = actionInstance.defaultAction();
        else
            fk = actionInstance.executeEvent(eventId);

        if (fk != null) {
            if ( log.isDebugEnabled() )
                log.debug("Received the Form Key: " + fk);
            if (ajaxForward!=null && ajaxForward.length()>0) {
                // This is an ajax request that should forward to a specific place
                // so it returns just a subset of a specific page
                if ( log.isDebugEnabled() )
                    log.debug("Set AJAX FormKey to '" + ajaxForward + "' (was originally '" + fk.getFormName() +"')");
                fk = new FormKey(ajaxForward, fk.getComponentId(), fk.getTitle());

                // Still needed for AJAX, if page forwared to use a <j:Form> to lookup current component
                request.setAttribute(FormKey.class.getName(), fk);
                // As this is a partial page with no <HEAD> tag the <j:Header/> tag can't be used to prevent
                // response caching, so do it directly on the response.
                response.setHeader("Cache-Control","no-cache");
                response.setHeader("Cache-Control","no-store");
                response.setDateHeader("Expires", 0);
                response.setHeader("Pragma","no-cache");

            } else {
                // Save the transaction token on the session and the component represented by the FormKey
                actionInstance.saveToken(fk);

                // Get the ContainerFormKey, if the component has one defined.
                fk = actionInstance.processContainerFormKey(fk);

                // Put this FormKey on the RequestStream
                request.setAttribute(FormKey.class.getName(), fk);

                // Add this FormKey to the historyNavList
                try {
                    HistoryNav.addFormKeyToHistoryNav(request, fk);
                } catch (Exception e) {
                    if (log.isInfoEnabled())
                        log.info("Exception thrown while trying to add the FormKey to the historyNavList", e);
                }
            }
            // forward to the Form
            String forwardName = actionInstance.parseFormName(fk.getFormName());
            ActionForward forward = mapping.findForward(forwardName);
            if (log.isDebugEnabled())
                log.debug("Forward object found from config file is " + forward);
            if (forward == null) {
                // use fk.getFormName() to keep the parameters in startComponent.do
                if (fk.getFormName().indexOf("://")>0 ||
                    fk.getFormName().indexOf('?')>0 )
                    forward = new ActionForward(fk.getFormName(), true);
                else
                    forward = new ActionForward(fk.getFormName());
            }
            if (log.isDebugEnabled())
                log.debug("Created new Forward object " + forward);
            return (forward);
        } else {
            // kill the userSession & return to the finalUrl
            return actionInstance.handleNullFormKey();
        }
    }

    /**
     * The default action method which should be overriden by the extending class.
     * This method is invoked by the perform() method, if no eventId is passed.
     * If the extending class doesn't provide an implementation of this method, a EventHandlerMissingRuntimeException will be thrown.
     * If all the 'submit' actions send an eventId, then there is no need to provide any implementation for this method.
     * @throws Exception if the application business logic throws an exception
     * @return A FormKey instance which describes the current Component & Form
     */
    protected FormKey defaultAction()
    throws Exception {
        String str = "No default action defined for the Action class " + this.getClass().getName();
        log.error(str);
        throw new EventHandlerMissingRuntimeException(str);
    }

    /** Save a new transaction token in the component.
     * @param fk The FormKey from which the component will be determined.
     */
    protected void saveToken(FormKey fk) {
        synchronized(request.getSession()) {
            // Save a token on the session using the struts method
            super.saveToken(request);

            // Save the token on the component represented by the input formkey
            if (fk != null && fk.getComponentId() != null) {
                Component comp = UserSession.getUserSession(request).getComponent(fk.getComponentId());
                if (comp != null)
                    comp.setToken((String) request.getSession().getAttribute(Globals.TRANSACTION_TOKEN_KEY));
            }
        }
    }

    /** Return true if there is a transaction token stored in the component, and the value submitted as a request parameter with this action matches it. Else it returns false.
     * @param request The servlet request we are processing
     * @return true if there is a transaction token stored in the component, and the value submitted as a request parameter with this action matches it. Else it returns false.
     */
    protected boolean isTokenValid(HttpServletRequest request) {
        return isTokenValid(request, false);
    }

    /** Return true if there is a transaction token stored in the component, and the value submitted as a request parameter with this action matches it. Else it returns false.
     * @param request The servlet request we are processing
     * @param reset Should we reset the token after checking it?
     * @return true if there is a transaction token stored in the component, and the value submitted as a request parameter with this action matches it. Else it returns false.
     */
    protected boolean isTokenValid(HttpServletRequest request, boolean reset) {
        synchronized(request.getSession()) {
            if (component != null)
                request.getSession().setAttribute(Globals.TRANSACTION_TOKEN_KEY, component.getToken());
            boolean valid = super.isTokenValid(request, reset);
            if (valid && reset)
                resetToken(request);
            return valid;
        }
    }

    /** Reset the saved transaction token in the component.  This
     * indicates that transactional token checking will not be needed
     * on the next request that is submitted.
     *
     * @param request The servlet request we are processing
     */
    protected void resetToken(HttpServletRequest request) {
        super.resetToken(request);
        if (component != null)
            component.setToken(null);
    }

    /** This merely invokes the isTokenValid() method and throws the ApplicationExceptions if the validation fails.
     * @param request The servlet request we are processing
     * @throws ApplicationExceptions if the token on the component does not match the token submitted as the request paramter.
     */
    protected void performTokenValidation(HttpServletRequest request) throws ApplicationExceptions {
        if (!isTokenValid(request)) {
            String str = "The token in the component does not match the token submitted as the request paramter.";
            if (log.isDebugEnabled())
                log.debug(str);
            ApplicationExceptions appExps = new ApplicationExceptions();
            appExps.add(new TokenMismatchException());
            throw appExps;
        }
    }

    /** Determines the currentFormKey, if possible, utilising the NAME field (if defined) and the componentId of the formBase.
     * This event is invoked when a user changes the settings of the UserGrid in a screen.
     * @return The FormKey for the Results screen.
     */
    public FormKey do_refresh() {
        if (log.isDebugEnabled())
            log.debug("Returning the CurrentFormKey for the refresh event");
        return determineCurrentFormKey((FormBase) form);
    }

    /** This is the handler for the event generated in the historyNav for rendering a previous screen.
     * @param index The index for the screen to be rendered. The most ancient screen(usually the Home) will be indexed '0'
     * @return The FormKey for a previous screen.
     */
    public FormKey do_HistoryNav_Clicked(String index) {
        FormKey fk = null;
        try {
            int i = Integer.parseInt(index);
            List historyNavList = HistoryNav.obtainHistoryNav(request);
            if (historyNavList != null && historyNavList.size() > i)
                fk = (FormKey) historyNavList.get(i);
        } catch (Exception e) {
            if (log.isInfoEnabled())
                log.info("Exception thrown while trying to obtain the FormKey from the historyNavList", e);
        }

        if (fk == null) {
            if (log.isDebugEnabled())
                log.debug("Unable to obtain the FormKey from the historyNavList. Will invoke the 'refresh' event to re-render the current screen");
            fk = do_refresh();
        }

        return fk;
    }


    /** This method will introspect this class for a suitable handler for the input eventId and invoke it.
     * @param eventId The event.
     * @throws Exception If any error occurs in introspection or invocation of the event-handler.
     * @return The output from the input handler.
     */
    protected FormKey executeEvent(String eventId)
    throws Exception {
        Method m = null;
        Object[] argumentValues = null;

        // Get all the possible methods for the eventId & invoke the 1st method which is available
        if (log.isDebugEnabled())
            log.debug("Evaluating the methods for handling the event " + eventId);

        EventHandler.Method[] methods = EventHandler.getEventMethods(eventId);
        if (methods != null) {
            Class actionClass = this.getClass();
            for (int i = 0; i < methods.length; i++) {
                EventHandler.Method method = methods[i];
                if (log.isDebugEnabled())
                    log.debug("Introspecting " + actionClass.getName() + " for the method " + method);

                try {
                    m = actionClass.getMethod(method.getName(), method.getArgumentTypes());
                } catch (Exception e) {
                    if (log.isDebugEnabled())
                        log.debug("Method not found - " + method);

                    // Not found.. so continue
                    m = null;
                    continue;
                }

                if (log.isDebugEnabled())
                    log.debug("Method found - " + method);

                // make sure the method returns a FormKey
                if ( FormKey.class.isAssignableFrom(m.getReturnType()) ) {
                    argumentValues = method.getArgumentValues();
                    break;
                } else {
                    m = null;
                    if (log.isDebugEnabled())
                        log.debug("'FormKey' is not returned by the method " + method);
                    continue;
                }
            }
        }

        if (m == null) {
            String str = "No method found for handling the event " + eventId;
            log.error(str);
            throw new EventHandlerMissingRuntimeException(str);
        }

        // Execute the method
        return (FormKey) m.invoke(this, argumentValues);
    }

    /** This is invoked whenever a null FormKey is returned by an event handler.
     * This will kill the UserSession, if the config property 'PROP_SECURITY_PORTLET_INVALIDATE_SESSION_BEFORE_REDIRECTING_TO_FINAL_URL' is set to true.
     * It will then redirect to the root of this webapp '/'.
     * @throws Exception if any error occurs.
     * @return The ActionForward representing the redirection to the root of this webapp '/'.
     */
    protected ActionForward handleNullFormKey()
    throws Exception {
        String invalidate = (String) Config.getProperty(Config.PROP_SECURITY_PORTLET_INVALIDATE_SESSION_BEFORE_REDIRECTING_TO_FINAL_URL, "true");
        if (Parser.parseBoolean(invalidate).booleanValue()) {
            if (log.isDebugEnabled())
                log.debug("Received Null FormKey. Killing the UserSession and Invalidating the HttpSession");
            if (UserSession.isUserSession(request))
                UserSession.getUserSession(request).kill();

            // Added by paule, to invalidate the authenticated session.
            HttpSession s = request.getSession(false);
            if(s!=null) s.invalidate();
        } else {
            if (log.isDebugEnabled())
                log.debug("Received Null FormKey. However the Session will not be invalidated.");
        }

        if (log.isDebugEnabled())
            log.debug("Redirecting to the Url '/'");
        return new ActionForward("/", true);
    }


    /** Determines the currentFormKey, if possible, utilising the NAME field (if defined) and the componentId of the formBase.
     * @param formBase The input FormBean from which the current FormKey is to be determined.
     * @return The current FormKey.
     */
    protected FormKey determineCurrentFormKey(FormBase formBase) {
        FormKey fk = null;
        Class clazz = formBase.getClass();
        try {
            Field nameField = clazz.getField(NAME);
            if (nameField != null) {
                Object name = nameField.get(formBase);
                if (name != null && name instanceof String && formBase.getComponent() != null) {
                    fk = new FormKey((String) name, formBase.getComponent().getComponentId());
                }
            }
        } catch (Exception e) {
            // do nothing
            if (log.isInfoEnabled())
                log.info("Exception thrown while trying to determine the NAME field of the Form " + formBase.getClass().getName(), e);
        }
        return fk;
    }

    /** This will parse the input FormName for parameters and set them as attributes on the request stream.
     * It will then return the FormName minus the parameters.
     * @param formName The input FormName.
     * @throws UnsupportedEncodingException This will be thrown if the JVM doesn't support the 'UTF-8' encoding. Highly unlikely that this will be thrown.
     * @return The FormName minus the parameters, if any.
     */
    protected String parseFormName(String formName)
    throws UnsupportedEncodingException {
        formName = URLDecoder.decode(formName, "UTF-8");
        int i = formName.indexOf('?');
        if (i > -1) {
            if (formName.length() > (i + 1)) {
                String parameterString = formName.substring(i + 1);
                StringTokenizer tokenizer = new StringTokenizer(parameterString, "=&");
                String attributeName = null;
                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    if (attributeName == null) {
                        attributeName = token;
                    } else {
                        request.setAttribute(attributeName, token);
                        attributeName = null;
                    }
                }
            }
            formName = formName.substring(0, i);
        }
        return formName;
    }

    /** Returns the ContainerFormKey, if the component specified by the input FormKey has one defined.
     * For such a component a FormKeyChangeEvent will be sent to the registered FormKeyChangeListeners.
     * @param fk The input FormKey.
     * @return The ContainerFormKey, if exists, or just the input FormKey.
     */
    protected FormKey processContainerFormKey(FormKey fk) {
        // The following should probably be invoked recursively. Will do so if the need arises !!
        UserSession us = UserSession.getUserSession(request);
        Component component = us.getComponent(fk.getComponentId());
        if (component != null && component.getContainerFormKey() != null && component.replaceWithContainerFormKey(fk)) {
            FormKeyChangeListener[] listeners = component.getFormKeyChangeListeners();
            if (listeners != null && listeners.length > 0) {
                FormKeyChangeEvent e = new FormKeyChangeEvent(this, fk);
                for (int i = 0; i < listeners.length; i++)
                    listeners[i].formKeyChanged(e);
            }
            fk = component.getContainerFormKey();
            if (log.isDebugEnabled())
                log.debug("The component in the received form key has a ContainerFormKey. Fired the FormKeyChangeListeners on the component and using the ContainerFormKey " + fk);
        }
        return fk;
    }

}
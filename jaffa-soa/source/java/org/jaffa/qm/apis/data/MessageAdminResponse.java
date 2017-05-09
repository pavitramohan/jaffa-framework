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
package org.jaffa.qm.apis.data;

import org.jaffa.soa.graph.ServiceError;

/**
 * Encapsulates the response to a Message administration operation.
 *
 * @author GautamJ
 */
public class MessageAdminResponse {

    private MessageGraph source;
    private ServiceError[] errors;

    public MessageAdminResponse() {
    }

    public MessageAdminResponse(MessageGraph source, ServiceError[] errors) {
        this.source = source;
        this.errors = errors;
    }

    /**
     * Getter for property source. This is the source GraphDataObject that the error occurred on.
     * @return Value of property source.
     */
    public MessageGraph getSource() {
        return source;
    }

    /**
     * Setter for property source.
     * @param source New value of property source.
     */
    public void setSource(MessageGraph source) {
        this.source = source;
    }

    /**
     * Getter for property errors.
     * @return Value of property errors.
     */
    public ServiceError[] getErrors() {
        return this.errors;
    }

    /**
     * Setter for property errors.
     * @param errors New value of property errors.
     */
    public void setErrors(ServiceError[] errors) {
        this.errors = errors;
    }

    /**
     * Returns diagnostic information.
     * @return diagnostic information.
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder("<MessageAdminResponse>");
        if (getSource() != null)
            buf.append(getSource());
        if (getErrors() != null) {
            for (Object o : getErrors())
                buf.append(o);
        }
        buf.append("</MessageAdminResponse>");
        return buf.toString();
    }
}

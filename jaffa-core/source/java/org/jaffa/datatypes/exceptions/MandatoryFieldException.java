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

package org.jaffa.datatypes.exceptions;

import org.jaffa.datatypes.ValidationException;

/** This is thrown by the FieldValidator if the value to be validated is null.*/
public class MandatoryFieldException extends ValidationException {
    
    /** This is used to locate the error message for the MandatoryFieldException. */
    public static final String ERROR_CODE = "exception.org.jaffa.exceptions.ValidationException.mandatoryField";
    
    /** Constructs a new MandatoryFieldException.
     */
    public MandatoryFieldException() {
        this(null);
    }
    
    /** Constructs a new MandatoryFieldException.
     * @param field the field on which the exception is being thrown. This can be set later too.
     */
    public MandatoryFieldException(String field) {
        this(field, null);
    }
    
    /** Constructs a new MandatoryFieldException.
     * This will merge the 'field' and the 'args' into a single Object array and use that for constructing the message. Hence, it is imperative that the error message has the field as the first argument.
     * @param field the field on which the exception is being thrown. This can be set later too.
     * @param args the arguments (everything other than the field), if any, that need to be merged into the error message from the resource bundle.
     */
    public MandatoryFieldException(String field, Object[] args) {
        this(field, args, null);
    }
    
    /** Constructs a new MandatoryFieldException.
     * This will merge the 'field' and the 'args' into a single Object array and use that for constructing the message. Hence, it is imperative that the error message have the field as argument 0.
     * @param field the field on which the exception is being thrown. This can be set later too.
     * @param args the arguments, if any, that need to be merged into the error message from the resource bundle.
     * @param cause the cause (which is saved for later retrieval by the Throwable.getCause() method). A null value is permitted, and indicates that the cause is nonexistent or unknown.
     */
    public MandatoryFieldException(String field, Object[] args, Throwable cause) {
        super(ERROR_CODE, field, args, cause);
    }
    
}

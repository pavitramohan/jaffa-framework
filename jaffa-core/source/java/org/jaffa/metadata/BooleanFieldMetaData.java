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

package org.jaffa.metadata;

import org.jaffa.datatypes.Defaults;

/**
 * An instance of this class will hold meta information for a Boolean field.
 */
public class BooleanFieldMetaData extends FieldMetaData {

    /** The default width.*/
    public static final int DEFAULT_WIDTH = 2;

    /** The default layout.*/
    public static final String DEFAULT_LAYOUT = null;

    /** The default pattern.*/
    public static final String DEFAULT_PATTERN = null;

    // NOTE: keep the equals(), clone(), compareTo(), hashCode() methods in sync
    private String m_layout = null;
    private String m_pattern = null;

    /** Creates an instance.
     */
    public BooleanFieldMetaData() {
        this(null, null, Boolean.FALSE, null, null);
    }

    /** Creates an instance.
     * @param name The field name.
     * @param labelToken The token used for displaying labels.
     * @param isMandatory Indicates if the field is mandatory.
     * @param layout The layout.
     * @param pattern The pattern.
     */
    public BooleanFieldMetaData(String name,String labelToken,
    Boolean isMandatory,String layout,String pattern) {
        super(name, Defaults.BOOLEAN, labelToken, isMandatory);
        m_layout = layout;
        m_pattern = pattern;
    }

    /** Getter for property layout.
     * @return Value of property layout.
     */
    public String getLayout() {
        return m_layout;
    }

    /** Getter for property pattern.
     * @return Value of property pattern.
     */
    public String getPattern() {
        return m_pattern;
    }

    /** Returns a clone of the object.
     * @return a clone of the object.
     */
    public Object clone() {
        // no more processing required since the fields are immutable
        return  super.clone();
    }

    /** Returns the hash code.
     * @return the hash code.
     */
    public int hashCode() {
        int i = 0;
        i = super.hashCode();
        if ( m_layout != null ) i += m_layout.hashCode();
        if ( m_pattern != null ) i += m_pattern.hashCode();
        return i;
    }

    /** Compares this object with another BooleanFieldMetaData object.
     * Returns a true if both the objects have the same properties.
     * @param obj the other BooleanFieldMetaData object.
     * @return a true if both the objects have the same properties.
     */
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if ( obj instanceof BooleanFieldMetaData ) {
            BooleanFieldMetaData field2 = (BooleanFieldMetaData) obj;
            if ( super.equals(field2) ) {
                if ( ( ( m_layout!=null && m_layout.equals(field2.m_layout) ) || (m_layout == null && field2.m_layout == null) )
                && ( ( m_pattern!=null && m_pattern.equals(field2.m_pattern) ) || (m_pattern == null && field2.m_pattern == null) ) )
                    isEqual = true;
            }
        }
        return isEqual;
    }

    /** Compares this object with another BooleanFieldMetaData object.
     * Note: this class has a natural ordering that is inconsistent with equals
     * @param obj the other BooleanFieldMetaData object.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    public int compareTo(Object obj) {
        // NOTE: this isnt a perfect compare !!!
        return super.compareTo(obj);
    }

    /** Returns the diagnostic information.
     * @return the diagnostic information.
     */
    public String toString() {
        String comma = ", ";
        String equals = "=";
        StringBuffer buffer = new StringBuffer( super.toString() );

        buffer.append(comma); buffer.append("Layout"); buffer.append(equals); buffer.append(m_layout);
        buffer.append(comma); buffer.append("Pattern"); buffer.append(equals); buffer.append(m_pattern);

        return buffer.toString();
    }

    /** Getter for property width.
     * @return Value of property width.
     */
    public int getWidth() {
        return DEFAULT_WIDTH;
    }
}

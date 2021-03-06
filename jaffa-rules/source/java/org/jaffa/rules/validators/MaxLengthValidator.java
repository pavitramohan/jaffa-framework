/*
 * ====================================================================
 * JAFFA - Java Application Framework For All
 *
 * Copyright (C) 2015 JAFFA Development Group
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
package org.jaffa.rules.validators;

import org.apache.log4j.Logger;
import org.jaffa.datatypes.Currency;
import org.jaffa.datatypes.exceptions.TooMuchDataException;
import org.jaffa.exceptions.ApplicationException;
import org.jaffa.exceptions.FrameworkException;
import org.jaffa.rules.meta.RuleMetaData;
import org.jaffa.rules.rulemeta.InvalidRuleParameterException;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.List;

/**
 * Validates that string properties do not violate their maximum length.
 */
public class MaxLengthValidator<T> extends RuleValidator<T> {

    private static Logger log = Logger.getLogger(MaxLengthValidator.class);

    /**
     * Constructs a validator with no rules.
     */
    public MaxLengthValidator() {
        super("max-length");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void validateProperty(T targetObject, String targetPropertyName, Object targetPropertyValue,
                                    List<RuleMetaData> rules) throws ApplicationException, FrameworkException {
        if (targetPropertyValue != null) {

            for (RuleMetaData rule : rules) {
                if (log.isDebugEnabled()) {
                    log.debug("Applying " + rule + " on " + targetPropertyValue);
                }

                if (rule.getName().equalsIgnoreCase(getName())) {
                    // Determine the intSize and fracSize
                    Integer intSize = null;
                    Integer fracSize = null;

                    try {
                        String[] sizes = rule.getParameter(RuleMetaData.PARAMETER_VALUE).split(",");
                        if (sizes.length >= 1 && sizes[0] != null && sizes[0].length() > 0) {
                            intSize = new Integer(sizes[0]);
                        }
                        if (sizes.length >= 2 && sizes[1] != null && sizes[1].length() > 0) {
                            fracSize = new Integer(sizes[1]);
                        }
                    } catch (NumberFormatException e) {
                        throw new InvalidRuleParameterException(targetPropertyName, getName(), "value", rule.getParameter(RuleMetaData.PARAMETER_VALUE));
                    }

                    if (intSize != null || fracSize != null) {
                        if (targetPropertyValue instanceof String) {
                            if (intSize != null && ((String) targetPropertyValue).length() > intSize.intValue()) {
                                throw logErrorCreateException(targetObject, targetPropertyName, targetPropertyValue, rule);
                            }
                        } else if (targetPropertyValue instanceof Number) {
                            if (!checkLength((Number) targetPropertyValue, intSize, fracSize)) {
                                throw logErrorCreateException(targetObject, targetPropertyName, targetPropertyValue, rule);
                            }
                        } else if (targetPropertyValue instanceof Currency) {
                            if (!checkLength(((Currency) targetPropertyValue).getValue(), intSize, fracSize)) {
                                throw logErrorCreateException(targetObject, targetPropertyName, targetPropertyValue, rule);
                            }
                        } else {
                            if (log.isDebugEnabled())
                                log.debug("This rule does not support instances of " + targetPropertyValue.getClass().getName());
                        }
                    }
                }
            }
        }
    }

    /** This method will ensure that the input Number does not exceed the specified limits.
     * @param input The number whose length is to be checked.
     * @param intSize The upper limit on the number of digits allowed before the decimal.
     * @param fracSize The upper limit on the number of digits allowed after the decimal.
     * @return a true if the input Number is within the specified limits.
     */
    private boolean checkLength(Number input, Integer intSize, Integer fracSize) {
        if (input != null && (intSize != null || fracSize != null)) {
            double value = Math.abs(input.doubleValue());

            if (intSize != null) {
                double intLimit = Math.pow(10, intSize.intValue());
                if ((long) value >= (long) intLimit)
                    return false;
            }

            if (fracSize != null) {
                // @todo: should find a much more efficient way of finding the no. of fractional digits
                StringBuffer buf = new StringBuffer();
                FieldPosition fp = new FieldPosition(NumberFormat.FRACTION_FIELD);
                NumberFormat df = NumberFormat.getNumberInstance();
                df.setGroupingUsed(false);
                df.setMaximumFractionDigits(20); // THIS SHOULD BE SUFFICIENT
                df.format(value, buf, fp);
                String fracString = buf.substring(fp.getBeginIndex(), fp.getEndIndex());
                if (fracString != null && fracString.length() > fracSize.intValue())
                    return false;
            }
        }
        return true;
    }

    /**
     * Logs a debug message and creates a TooMuchDataException exception that can to throw by the caller.
     *
     * @param targetObject        the target object.
     * @param targetPropertyName  the target property name.
     * @param targetPropertyValue the target property value.
     * @param rule                the rule that failed validation.
     * @return the exception to throw
     */
    private ApplicationException logErrorCreateException(T targetObject, String targetPropertyName,
                                                         Object targetPropertyValue, RuleMetaData rule) {
        if (log.isDebugEnabled()) {
            log.debug("The length of the value '" + targetPropertyValue + "' exceeds '" + rule.getParameter(RuleMetaData.PARAMETER_VALUE) + "'");
        }

        return wrapException(TooMuchDataException.class, targetObject, targetPropertyName, rule);
    }
}

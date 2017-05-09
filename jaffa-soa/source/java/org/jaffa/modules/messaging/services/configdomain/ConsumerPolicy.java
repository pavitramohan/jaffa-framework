//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.09.29 at 04:28:25 PM PDT 
//


package org.jaffa.modules.messaging.services.configdomain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consumerPolicy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="consumerPolicy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="single"/>
 *     &lt;enumeration value="multi"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "consumerPolicy")
@XmlEnum
public enum ConsumerPolicy {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("single")
    SINGLE("single"),
    @XmlEnumValue("multi")
    MULTI("multi");
    private final String value;

    ConsumerPolicy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConsumerPolicy fromValue(String v) {
        for (ConsumerPolicy c: ConsumerPolicy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

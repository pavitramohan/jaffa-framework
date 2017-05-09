//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.09.29 at 04:28:25 PM PDT 
//


package org.jaffa.modules.messaging.services.configdomain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * 
 *         The syntax for the filter will be based on a subset of the SQL92 conditional expression syntax. Check the latest JMS specification for more details
 *         
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ul xmlns:jxb="http://java.sun.com/xml/ns/jaxb" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;li&gt;&lt;b&gt;value&lt;/b&gt;: the filter to apply. It could be a literal. Or it could be expression, which gets evaluated at runtime. JaffaMessaging utilizes the Bean Scripting Framework (BSF) for evaluating expressions. It sets up a context for BSF with the following elements

 *             &lt;ul&gt;&lt;li&gt;&lt;b&gt;context&lt;/b&gt;: contains the global context&lt;/li&gt;&lt;li&gt;&lt;b&gt;bean&lt;/b&gt;: contains the POJO&lt;/li&gt;

 *             &lt;/ul&gt;

 *           &lt;/li&gt;&lt;li&gt;&lt;b&gt;expression&lt;/b&gt;: a flag to indicate if the value contains a literal, or an expression that should evaluated at runtime&lt;/li&gt;&lt;li&gt;&lt;b&gt;language&lt;/b&gt;: indicates the scripting language used for writing the expression, if any. It should be compatible with BSF. It defaults to beanshell&lt;/li&gt;

 *         &lt;/ul&gt;
 * </pre>
 * 
 *       
 * 
 * <p>Java class for filter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="filter">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="expression" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="language" type="{http://www.w3.org/2001/XMLSchema}string" default="beanshell" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filter", propOrder = {
    "value"
})
public class Filter {

    @XmlValue
    protected String value;
    @XmlAttribute
    protected Boolean expression;
    @XmlAttribute
    protected String language;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the expression property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isExpression() {
        if (expression == null) {
            return false;
        } else {
            return expression;
        }
    }

    /**
     * Sets the value of the expression property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExpression(Boolean value) {
        this.expression = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        if (language == null) {
            return "beanshell";
        } else {
            return language;
        }
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

}

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


/**
 * 
 *         message-filter provides a mechanism to filter messages.
 *         An IMessageFilter implementation may inspect the input payloads.
 *         It may choose to leave them as-is, modify them, add new payload(s), or replace some of them with new payload(s).
 *         It may even choose to empty the List, thereby stopping the submission of any message to the messaging system.
 *         
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ul xmlns:jxb="http://java.sun.com/xml/ns/jaxb" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;li&gt;&lt;b&gt;filter-name&lt;/b&gt;: the name of this message-filter&lt;/li&gt;&lt;li&gt;&lt;b&gt;filter-class&lt;/b&gt;: fully qualified name of a class that implements the IMessageFilter interface&lt;/li&gt;

 *         &lt;/ul&gt;
 * </pre>
 * 
 *       
 * 
 * <p>Java class for message-filter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="message-filter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="filter-name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="filter-class" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "message-filter")
public class MessageFilter {

    @XmlAttribute(name = "filter-name", required = true)
    protected String filterName;
    @XmlAttribute(name = "filter-class", required = true)
    protected String filterClass;

    /**
     * Gets the value of the filterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterName() {
        return filterName;
    }

    /**
     * Sets the value of the filterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterName(String value) {
        this.filterName = value;
    }

    /**
     * Gets the value of the filterClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterClass() {
        return filterClass;
    }

    /**
     * Sets the value of the filterClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterClass(String value) {
        this.filterClass = value;
    }

}
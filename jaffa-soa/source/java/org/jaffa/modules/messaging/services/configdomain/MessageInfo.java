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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         messageInfo maps a POJO to a Queue/Topic, and declares the Message handler
 *         
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ul xmlns:jxb="http://java.sun.com/xml/ns/jaxb" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;li&gt;&lt;b&gt;lock-check&lt;/b&gt;: lists the elements to check in the Headers of existing Messages, the presence of which would result in a LockingServiceException. The check is performed before writing the Message. NOTE that this feature is not applicable for a Topic.&lt;/li&gt;&lt;li&gt;&lt;b&gt;header&lt;/b&gt;: lists the elements to add to the Message header&lt;/li&gt;&lt;li&gt;&lt;b&gt;dataBean&lt;/b&gt;: the fully qualified class name of the POJO&lt;/li&gt;&lt;li&gt;&lt;b&gt;queueName&lt;/b&gt;: the queue name. Either the queueName or the topicName should be provided&lt;/li&gt;&lt;li&gt;&lt;b&gt;topicName&lt;/b&gt;: the topic name. Either the queueName or the topicName should be provided&lt;/li&gt;&lt;li&gt;&lt;b&gt;toClass&lt;/b&gt;: the fully qualified class name of the handler. Need not be specified, if the corresponding Queue/Topic has no consumers attached to it&lt;/li&gt;&lt;li&gt;&lt;b&gt;toMethod&lt;/b&gt;: the handler method, which gets invoked by the JaffaMessageBean, which consumes the Message. The method signature should have the POJO as an input argument. Need not be specified, if the corresponding Queue/Topic has no consumers attached to it&lt;/li&gt;

 *         &lt;/ul&gt;
 * </pre>
 * 
 *       
 * 
 * <p>Java class for messageInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="messageInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lock-check" type="{}lock-check" minOccurs="0"/>
 *         &lt;element name="header" type="{}header" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="dataBean" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="queueName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="topicName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="toClass" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="toMethod" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messageInfo", propOrder = {
    "lockCheck",
    "header"
})
public class MessageInfo {

    @XmlElement(name = "lock-check")
    protected LockCheck lockCheck;
    protected Header header;
    @XmlAttribute(required = true)
    protected String dataBean;
    @XmlAttribute
    protected String queueName;
    @XmlAttribute
    protected String topicName;
    @XmlAttribute
    protected String toClass;
    @XmlAttribute
    protected String toMethod;

    /**
     * Gets the value of the lockCheck property.
     * 
     * @return
     *     possible object is
     *     {@link LockCheck }
     *     
     */
    public LockCheck getLockCheck() {
        return lockCheck;
    }

    /**
     * Sets the value of the lockCheck property.
     * 
     * @param value
     *     allowed object is
     *     {@link LockCheck }
     *     
     */
    public void setLockCheck(LockCheck value) {
        this.lockCheck = value;
    }

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link Header }
     *     
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link Header }
     *     
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the dataBean property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataBean() {
        return dataBean;
    }

    /**
     * Sets the value of the dataBean property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataBean(String value) {
        this.dataBean = value;
    }

    /**
     * Gets the value of the queueName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueueName() {
        return queueName;
    }

    /**
     * Sets the value of the queueName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueueName(String value) {
        this.queueName = value;
    }

    /**
     * Gets the value of the topicName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTopicName() {
        return topicName;
    }

    /**
     * Sets the value of the topicName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTopicName(String value) {
        this.topicName = value;
    }

    /**
     * Gets the value of the toClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToClass() {
        return toClass;
    }

    /**
     * Sets the value of the toClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToClass(String value) {
        this.toClass = value;
    }

    /**
     * Gets the value of the toMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToMethod() {
        return toMethod;
    }

    /**
     * Sets the value of the toMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToMethod(String value) {
        this.toMethod = value;
    }

}

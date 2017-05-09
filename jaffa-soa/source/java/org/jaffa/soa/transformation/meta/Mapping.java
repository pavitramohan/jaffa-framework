//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.05 at 02:10:55 AM IST 
//


package org.jaffa.soa.transformation.meta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="path" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="xsltscript" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="inboundSchema" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rootElement" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="qName" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="array" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="function" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="endpoint" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="direction" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="IN"/>
 *             &lt;enumeration value="OUT"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "mapping")
public class Mapping {

    @XmlAttribute
    protected String path;
    @XmlAttribute(required = true)
    protected String xsltscript;
    @XmlAttribute
    protected String inboundSchema;
    @XmlAttribute
    protected String rootElement;
    @XmlAttribute
    @XmlSchemaType(name = "anySimpleType")
    protected String qName;
    @XmlAttribute
    protected Boolean array;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String function;
    @XmlAttribute(required = true)
    protected String endpoint;
    @XmlAttribute(required = true)
    protected String direction;

    /**
     * Gets the value of the path property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * Gets the value of the xsltscript property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXsltscript() {
        return xsltscript;
    }

    /**
     * Sets the value of the xsltscript property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXsltscript(String value) {
        this.xsltscript = value;
    }

    /**
     * Gets the value of the inboundSchema property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInboundSchema() {
        return inboundSchema;
    }

    /**
     * Sets the value of the inboundSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInboundSchema(String value) {
        this.inboundSchema = value;
    }

    /**
     * Gets the value of the rootElement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRootElement() {
        return rootElement;
    }

    /**
     * Sets the value of the rootElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRootElement(String value) {
        this.rootElement = value;
    }

    /**
     * Gets the value of the qName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQName() {
        return qName;
    }

    /**
     * Sets the value of the qName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQName(String value) {
        this.qName = value;
    }

    /**
     * Gets the value of the array property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isArray() {
        return array;
    }

    /**
     * Sets the value of the array property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setArray(Boolean value) {
        this.array = value;
    }

    /**
     * Gets the value of the function property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunction() {
        return function;
    }

    /**
     * Sets the value of the function property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunction(String value) {
        this.function = value;
    }

    /**
     * Gets the value of the endpoint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Sets the value of the endpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndpoint(String value) {
        this.endpoint = value;
    }

    /**
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirection(String value) {
        this.direction = value;
    }

}

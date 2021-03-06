//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.09 at 01:41:50 PM PST 
//


package org.jaffa.presentation.portlet.component.componentdomain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for component complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="component">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="url-action" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="license-ref" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="default-navigation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mandatory-function" type="{}mandatory-function" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="optional-function" type="{}optional-function" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dependent-component" type="{}dependent-component" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="use-design-pattern" type="{}use-design-pattern" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="params" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                   &lt;choice>
 *                     &lt;element name="param-string" type="{}stringTypeParam"/>
 *                     &lt;element name="param-int" type="{}intTypeParam"/>
 *                     &lt;element name="param-boolean" type="{}booleanTypeParam"/>
 *                     &lt;element name="param-object" type="{}objectTypeParam"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "component", propOrder = {
    "description",
    "className",
    "urlAction",
    "type",
    "licenseRef",
    "defaultNavigation",
    "mandatoryFunction",
    "optionalFunction",
    "dependentComponent",
    "useDesignPattern",
    "params"
})
public class Component {

    protected String description;
    @XmlElement(name = "class", required = true)
    protected String className;
    @XmlElement(name = "url-action")
    protected String urlAction;
    protected String type;
    @XmlElement(name = "license-ref")
    protected String licenseRef;
    @XmlElement(name = "default-navigation")
    protected String defaultNavigation;
    @XmlElement(name = "mandatory-function")
    protected List<MandatoryFunction> mandatoryFunction;
    @XmlElement(name = "optional-function")
    protected List<OptionalFunction> optionalFunction;
    @XmlElement(name = "dependent-component")
    protected List<DependentComponent> dependentComponent;
    @XmlElement(name = "use-design-pattern")
    protected List<UseDesignPattern> useDesignPattern;
    protected Component.Params params;
    @XmlAttribute(required = true)
    protected String id;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the className property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the value of the className property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassName(String value) {
        this.className = value;
    }

    /**
     * Gets the value of the urlAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlAction() {
        return urlAction;
    }

    /**
     * Sets the value of the urlAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlAction(String value) {
        this.urlAction = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the licenseRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseRef() {
        return licenseRef;
    }

    /**
     * Sets the value of the licenseRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseRef(String value) {
        this.licenseRef = value;
    }

    /**
     * Gets the value of the defaultNavigation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultNavigation() {
        return defaultNavigation;
    }

    /**
     * Sets the value of the defaultNavigation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultNavigation(String value) {
        this.defaultNavigation = value;
    }

    /**
     * Gets the value of the mandatoryFunction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mandatoryFunction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMandatoryFunction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MandatoryFunction }
     * 
     * 
     */
    public List<MandatoryFunction> getMandatoryFunction() {
        if (mandatoryFunction == null) {
            mandatoryFunction = new ArrayList<MandatoryFunction>();
        }
        return this.mandatoryFunction;
    }

    /**
     * Gets the value of the optionalFunction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the optionalFunction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptionalFunction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OptionalFunction }
     * 
     * 
     */
    public List<OptionalFunction> getOptionalFunction() {
        if (optionalFunction == null) {
            optionalFunction = new ArrayList<OptionalFunction>();
        }
        return this.optionalFunction;
    }

    /**
     * Gets the value of the dependentComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dependentComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDependentComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DependentComponent }
     * 
     * 
     */
    public List<DependentComponent> getDependentComponent() {
        if (dependentComponent == null) {
            dependentComponent = new ArrayList<DependentComponent>();
        }
        return this.dependentComponent;
    }

    /**
     * Gets the value of the useDesignPattern property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the useDesignPattern property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUseDesignPattern().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UseDesignPattern }
     * 
     * 
     */
    public List<UseDesignPattern> getUseDesignPattern() {
        if (useDesignPattern == null) {
            useDesignPattern = new ArrayList<UseDesignPattern>();
        }
        return this.useDesignPattern;
    }

    /**
     * Gets the value of the params property.
     * 
     * @return
     *     possible object is
     *     {@link Component.Params }
     *     
     */
    public Component.Params getParams() {
        return params;
    }

    /**
     * Sets the value of the params property.
     * 
     * @param value
     *     allowed object is
     *     {@link Component.Params }
     *     
     */
    public void setParams(Component.Params value) {
        this.params = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
     *         &lt;choice>
     *           &lt;element name="param-string" type="{}stringTypeParam"/>
     *           &lt;element name="param-int" type="{}intTypeParam"/>
     *           &lt;element name="param-boolean" type="{}booleanTypeParam"/>
     *           &lt;element name="param-object" type="{}objectTypeParam"/>
     *         &lt;/choice>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "paramStringOrParamIntOrParamBoolean"
    })
    public static class Params {

        @XmlElements({
            @XmlElement(name = "param-int", type = IntTypeParam.class),
            @XmlElement(name = "param-string", type = StringTypeParam.class),
            @XmlElement(name = "param-object", type = ObjectTypeParam.class),
            @XmlElement(name = "param-boolean", type = BooleanTypeParam.class)
        })
        protected List<Object> paramStringOrParamIntOrParamBoolean;

        /**
         * Gets the value of the paramStringOrParamIntOrParamBoolean property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the paramStringOrParamIntOrParamBoolean property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getParamStringOrParamIntOrParamBoolean().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link IntTypeParam }
         * {@link StringTypeParam }
         * {@link ObjectTypeParam }
         * {@link BooleanTypeParam }
         * 
         * 
         */
        public List<Object> getParamStringOrParamIntOrParamBoolean() {
            if (paramStringOrParamIntOrParamBoolean == null) {
                paramStringOrParamIntOrParamBoolean = new ArrayList<Object>();
            }
            return this.paramStringOrParamIntOrParamBoolean;
        }

    }

}

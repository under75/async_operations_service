//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.09 at 11:51:12 AM GMT+04:00 
//


package ru.tfoms.schemas.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Contact complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Contact"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="contactType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contactText" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dsource" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dsourceType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Contact", namespace = "http://ffoms.ru/types/commonTypes", propOrder = {
    "contactType",
    "descr",
    "contactText",
    "dsource",
    "dsourceType"
})
public class Contact {

    @XmlElement(required = true)
    protected String contactType;
    protected String descr;
    @XmlElement(required = true)
    protected String contactText;
    @XmlElement(required = true)
    protected String dsource;
    @XmlElement(required = true)
    protected String dsourceType;

    /**
     * Gets the value of the contactType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactType() {
        return contactType;
    }

    /**
     * Sets the value of the contactType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactType(String value) {
        this.contactType = value;
    }

    /**
     * Gets the value of the descr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescr() {
        return descr;
    }

    /**
     * Sets the value of the descr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescr(String value) {
        this.descr = value;
    }

    /**
     * Gets the value of the contactText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactText() {
        return contactText;
    }

    /**
     * Sets the value of the contactText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactText(String value) {
        this.contactText = value;
    }

    /**
     * Gets the value of the dsource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsource() {
        return dsource;
    }

    /**
     * Sets the value of the dsource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsource(String value) {
        this.dsource = value;
    }

    /**
     * Gets the value of the dsourceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsourceType() {
        return dsourceType;
    }

    /**
     * Sets the value of the dsourceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsourceType(String value) {
        this.dsourceType = value;
    }

}

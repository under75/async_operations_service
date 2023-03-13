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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Массив с адресными данными застрахованного лица.
 * 
 * <p>Java class for Address complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Address"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="okato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="oksm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="aoguid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hsguid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="addressText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mailIndex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="appNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dsourceType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dsource" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="addressType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="addressDateB" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="addressDateE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Address", namespace = "http://ffoms.ru/types/commonTypes", propOrder = {
    "okato",
    "oksm",
    "aoguid",
    "hsguid",
    "addressText",
    "mailIndex",
    "appNum",
    "dsourceType",
    "dsource",
    "addressType",
    "addressDateB",
    "addressDateE"
})
public class Address {

    protected String okato;
    protected String oksm;
    protected String aoguid;
    protected String hsguid;
    protected String addressText;
    protected String mailIndex;
    protected String appNum;
    @XmlElement(required = true)
    protected String dsourceType;
    @XmlElement(required = true)
    protected String dsource;
    @XmlElement(required = true)
    protected String addressType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar addressDateB;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar addressDateE;

    /**
     * Gets the value of the okato property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOkato() {
        return okato;
    }

    /**
     * Sets the value of the okato property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOkato(String value) {
        this.okato = value;
    }

    /**
     * Gets the value of the oksm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOksm() {
        return oksm;
    }

    /**
     * Sets the value of the oksm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOksm(String value) {
        this.oksm = value;
    }

    /**
     * Gets the value of the aoguid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAoguid() {
        return aoguid;
    }

    /**
     * Sets the value of the aoguid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAoguid(String value) {
        this.aoguid = value;
    }

    /**
     * Gets the value of the hsguid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHsguid() {
        return hsguid;
    }

    /**
     * Sets the value of the hsguid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHsguid(String value) {
        this.hsguid = value;
    }

    /**
     * Gets the value of the addressText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressText() {
        return addressText;
    }

    /**
     * Sets the value of the addressText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressText(String value) {
        this.addressText = value;
    }

    /**
     * Gets the value of the mailIndex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailIndex() {
        return mailIndex;
    }

    /**
     * Sets the value of the mailIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailIndex(String value) {
        this.mailIndex = value;
    }

    /**
     * Gets the value of the appNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppNum() {
        return appNum;
    }

    /**
     * Sets the value of the appNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppNum(String value) {
        this.appNum = value;
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
     * Gets the value of the addressType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * Sets the value of the addressType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressType(String value) {
        this.addressType = value;
    }

    /**
     * Gets the value of the addressDateB property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAddressDateB() {
        return addressDateB;
    }

    /**
     * Sets the value of the addressDateB property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAddressDateB(XMLGregorianCalendar value) {
        this.addressDateB = value;
    }

    /**
     * Gets the value of the addressDateE property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAddressDateE() {
        return addressDateE;
    }

    /**
     * Sets the value of the addressDateE property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAddressDateE(XMLGregorianCalendar value) {
        this.addressDateE = value;
    }

}

//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.03 at 03:44:13 PM GMT+04:00 
//


package ru.tfoms.schemas.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Массив с документами, удостоверяющими личность.
 * 
 * <p>Java class for PersonDocIdentFullBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonDocIdentFullBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ffoms.ru/types/commonTypes}PersonDocIdentShortBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dudlDateE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="issuer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="issuerOksm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ctznOksm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noCitizenship" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="descr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="birthDay" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="birthplace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="gender" type="{http://ffoms.ru/types/commonTypes}GenderType"/&gt;
 *         &lt;element name="birthOksm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonDocIdentFullBase", namespace = "http://ffoms.ru/types/commonTypes", propOrder = {
    "dudlDateE",
    "issuer",
    "issuerOksm",
    "ctznOksm",
    "noCitizenship",
    "descr",
    "birthDay",
    "birthplace",
    "gender",
    "birthOksm",
    "dost"
})
public class PersonDocIdentFullBase
    extends PersonDocIdentShortBase
{

    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dudlDateE;
    protected String issuer;
    protected String issuerOksm;
    protected String ctznOksm;
    protected boolean noCitizenship;
    protected String descr;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthDay;
    protected String birthplace;
    @XmlSchemaType(name = "integer")
    protected int gender;
    protected String birthOksm;
    protected String dost;

    /**
     * Gets the value of the dudlDateE property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDudlDateE() {
        return dudlDateE;
    }

    /**
     * Sets the value of the dudlDateE property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDudlDateE(XMLGregorianCalendar value) {
        this.dudlDateE = value;
    }

    /**
     * Gets the value of the issuer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * Sets the value of the issuer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuer(String value) {
        this.issuer = value;
    }

    /**
     * Gets the value of the issuerOksm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuerOksm() {
        return issuerOksm;
    }

    /**
     * Sets the value of the issuerOksm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuerOksm(String value) {
        this.issuerOksm = value;
    }

    /**
     * Gets the value of the ctznOksm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtznOksm() {
        return ctznOksm;
    }

    /**
     * Sets the value of the ctznOksm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtznOksm(String value) {
        this.ctznOksm = value;
    }

    /**
     * Gets the value of the noCitizenship property.
     * 
     */
    public boolean isNoCitizenship() {
        return noCitizenship;
    }

    /**
     * Sets the value of the noCitizenship property.
     * 
     */
    public void setNoCitizenship(boolean value) {
        this.noCitizenship = value;
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
     * Gets the value of the birthDay property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDay() {
        return birthDay;
    }

    /**
     * Sets the value of the birthDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDay(XMLGregorianCalendar value) {
        this.birthDay = value;
    }

    /**
     * Gets the value of the birthplace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthplace() {
        return birthplace;
    }

    /**
     * Sets the value of the birthplace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthplace(String value) {
        this.birthplace = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     */
    public int getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     */
    public void setGender(int value) {
        this.gender = value;
    }

    /**
     * Gets the value of the birthOksm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthOksm() {
        return birthOksm;
    }

    /**
     * Sets the value of the birthOksm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthOksm(String value) {
        this.birthOksm = value;
    }

    /**
     * Gets the value of the dost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDost() {
        return dost;
    }

    /**
     * Sets the value of the dost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDost(String value) {
        this.dost = value;
    }

}

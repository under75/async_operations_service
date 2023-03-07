//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.07 at 10:24:45 AM GMT+04:00 
//


package ru.tfoms.schemas.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ffoms.ru/types/commonTypes}CommonRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dt" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="terr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="smo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dt",
    "terr",
    "smo"
})
@XmlRootElement(name = "getViewDataInsuranceStartRequest")
public class GetViewDataInsuranceStartRequest
    extends CommonRequestType
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dt;
    protected String terr;
    protected String smo;

    /**
     * Gets the value of the dt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDt() {
        return dt;
    }

    /**
     * Sets the value of the dt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDt(XMLGregorianCalendar value) {
        this.dt = value;
    }

    /**
     * Gets the value of the terr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerr() {
        return terr;
    }

    /**
     * Sets the value of the terr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerr(String value) {
        this.terr = value;
    }

    /**
     * Gets the value of the smo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmo() {
        return smo;
    }

    /**
     * Sets the value of the smo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmo(String value) {
        this.smo = value;
    }

}

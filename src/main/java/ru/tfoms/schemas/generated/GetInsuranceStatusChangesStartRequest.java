//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.03 at 03:44:13 PM GMT+04:00 
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
 *         &lt;element name="dtFrom" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="dtTo" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="terr" type="{http://ffoms.ru/types/commonTypes}OkatoType"/&gt;
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
    "dtFrom",
    "dtTo",
    "terr",
    "smo"
})
@XmlRootElement(name = "getInsuranceStatusChangesStartRequest")
public class GetInsuranceStatusChangesStartRequest
    extends CommonRequestType
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dtFrom;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dtTo;
    @XmlElement(required = true)
    protected String terr;
    protected String smo;

    /**
     * Gets the value of the dtFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtFrom() {
        return dtFrom;
    }

    /**
     * Sets the value of the dtFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtFrom(XMLGregorianCalendar value) {
        this.dtFrom = value;
    }

    /**
     * Gets the value of the dtTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtTo() {
        return dtTo;
    }

    /**
     * Sets the value of the dtTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtTo(XMLGregorianCalendar value) {
        this.dtTo = value;
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
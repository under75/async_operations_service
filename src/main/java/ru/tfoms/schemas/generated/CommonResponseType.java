//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.09 at 11:39:12 AM GMT+04:00 
//


package ru.tfoms.schemas.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Результат запроса
 * 
 * <p>Java class for CommonResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommonResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="externalRequestId" type="{http://ffoms.ru/types/commonTypes}ExternalRequestIdType"/&gt;
 *         &lt;element name="errors" type="{http://ffoms.ru/types/commonTypes}ListOfErrors" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommonResponseType", namespace = "http://ffoms.ru/types/commonTypes", propOrder = {
    "externalRequestId",
    "errors"
})
@XmlSeeAlso({
    AsyncStartResponse.class
})
public class CommonResponseType {

    @XmlElement(required = true)
    protected String externalRequestId;
    protected ListOfErrors errors;

    /**
     * Gets the value of the externalRequestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalRequestId() {
        return externalRequestId;
    }

    /**
     * Sets the value of the externalRequestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalRequestId(String value) {
        this.externalRequestId = value;
    }

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link ListOfErrors }
     *     
     */
    public ListOfErrors getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOfErrors }
     *     
     */
    public void setErrors(ListOfErrors value) {
        this.errors = value;
    }

}

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
import javax.xml.bind.annotation.XmlType;


/**
 * код результата (http) и расшифровка ошибки
 * 
 * <p>Java class for ChangeResultResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChangeResultResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="enp" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codeResult" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeResultResponse", propOrder = {
    "enp",
    "codeResult"
})
public class ChangeResultResponse {

    @XmlElement(required = true)
    protected String enp;
    @XmlElement(required = true)
    protected String codeResult;

    /**
     * Gets the value of the enp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnp() {
        return enp;
    }

    /**
     * Sets the value of the enp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnp(String value) {
        this.enp = value;
    }

    /**
     * Gets the value of the codeResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeResult() {
        return codeResult;
    }

    /**
     * Sets the value of the codeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeResult(String value) {
        this.codeResult = value;
    }

}

//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.09 at 11:39:12 AM GMT+04:00 
//


package ru.tfoms.schemas.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ffoms.ru/types/commonTypes}AsyncPollResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="сhangeResult" type="{http://ffoms.ru/types/mpiAsyncOperationsSchema}ListOfChangeResult" minOccurs="0"/&gt;
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
    "\u0441hangeResult"
})
@XmlRootElement(name = "changeAllPoliciesInsuranceToTfomsPollResponse")
public class ChangeAllPoliciesInsuranceToTfomsPollResponse
    extends AsyncPollResponse
{

    protected ListOfChangeResult сhangeResult;

    /**
     * Gets the value of the сhangeResult property.
     * 
     * @return
     *     possible object is
     *     {@link ListOfChangeResult }
     *     
     */
    public ListOfChangeResult getСhangeResult() {
        return сhangeResult;
    }

    /**
     * Sets the value of the сhangeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOfChangeResult }
     *     
     */
    public void setСhangeResult(ListOfChangeResult value) {
        this.сhangeResult = value;
    }

}

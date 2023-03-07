//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.7 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.07 at 10:24:45 AM GMT+04:00 
//


package ru.tfoms.schemas.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlList;
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
 *         &lt;element name="enpArrived" type="{http://ffoms.ru/types/commonTypes}StringListType" minOccurs="0"/&gt;
 *         &lt;element name="enpDeparted" type="{http://ffoms.ru/types/commonTypes}StringListType" minOccurs="0"/&gt;
 *         &lt;element name="enpChanged" type="{http://ffoms.ru/types/commonTypes}StringListType" minOccurs="0"/&gt;
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
    "enpArrived",
    "enpDeparted",
    "enpChanged"
})
@XmlRootElement(name = "getInsuranceStatusChangesPollResponse")
public class GetInsuranceStatusChangesPollResponse
    extends AsyncPollResponse
{

    @XmlList
    protected List<String> enpArrived;
    @XmlList
    protected List<String> enpDeparted;
    @XmlList
    protected List<String> enpChanged;

    /**
     * Gets the value of the enpArrived property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enpArrived property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnpArrived().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEnpArrived() {
        if (enpArrived == null) {
            enpArrived = new ArrayList<String>();
        }
        return this.enpArrived;
    }

    /**
     * Gets the value of the enpDeparted property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enpDeparted property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnpDeparted().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEnpDeparted() {
        if (enpDeparted == null) {
            enpDeparted = new ArrayList<String>();
        }
        return this.enpDeparted;
    }

    /**
     * Gets the value of the enpChanged property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enpChanged property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnpChanged().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEnpChanged() {
        if (enpChanged == null) {
            enpChanged = new ArrayList<String>();
        }
        return this.enpChanged;
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.17 at 07:21:09 PM GST 
//


package open.code.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Список счетов для ПУР-получателя.
 * 
 * <p>Java class for PayeeAccInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PayeeAccInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="PayeeAcc" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}AccountNumberRUIDType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PayeeAccInfo")
public class PayeeAccInfo {

    @XmlAttribute(name = "PayeeAcc", required = true)
    protected String payeeAcc;

    /**
     * Gets the value of the payeeAcc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayeeAcc() {
        return payeeAcc;
    }

    /**
     * Sets the value of the payeeAcc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayeeAcc(String value) {
        this.payeeAcc = value;
    }

}
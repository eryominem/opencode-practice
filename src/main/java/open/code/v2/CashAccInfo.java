//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.17 at 07:21:09 PM GST 
//


package open.code.v2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Кассовая отчетность.
 * 
 * <p>Java class for CashAccInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CashAccInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="CashAccCode" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}CashAccountingCodeType" /&gt;
 *       &lt;attribute name="CashAccSum" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}KopeckAmountType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CashAccInfo")
public class CashAccInfo {

    @XmlAttribute(name = "CashAccCode", required = true)
    protected String cashAccCode;
    @XmlAttribute(name = "CashAccSum", required = true)
    protected BigInteger cashAccSum;

    /**
     * Gets the value of the cashAccCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCashAccCode() {
        return cashAccCode;
    }

    /**
     * Sets the value of the cashAccCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCashAccCode(String value) {
        this.cashAccCode = value;
    }

    /**
     * Gets the value of the cashAccSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCashAccSum() {
        return cashAccSum;
    }

    /**
     * Sets the value of the cashAccSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCashAccSum(BigInteger value) {
        this.cashAccSum = value;
    }

}

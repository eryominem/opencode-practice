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
 * Информация об устанавливаемом лимите
 * 
 * <p>Java class for LimitInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LimitInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="PURBIC" type="{urn:cbr-ru:ed:leaftypes:v2.0}BICRUIDType" /&gt;
 *       &lt;attribute name="LimitSum" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}NotNegativeKopeckAmountType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LimitInfo")
public class LimitInfo {

    @XmlAttribute(name = "PURBIC")
    protected String purbic;
    @XmlAttribute(name = "LimitSum", required = true)
    protected BigInteger limitSum;

    /**
     * Gets the value of the purbic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPURBIC() {
        return purbic;
    }

    /**
     * Sets the value of the purbic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPURBIC(String value) {
        this.purbic = value;
    }

    /**
     * Gets the value of the limitSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLimitSum() {
        return limitSum;
    }

    /**
     * Sets the value of the limitSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLimitSum(BigInteger value) {
        this.limitSum = value;
    }

}

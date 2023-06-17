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
 * Информация о косвенном участнике-плательщике.
 * 
 * <p>Java class for IndirectParticipantInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndirectParticipantInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="IPBIC" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}BICRUIDType" /&gt;
 *       &lt;attribute name="AggrementID" type="{urn:cbr-ru:ed:leaftypes:v2.0}TwoDigitIdentifierType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndirectParticipantInfoType")
public class IndirectParticipantInfoType {

    @XmlAttribute(name = "IPBIC", required = true)
    protected String ipbic;
    @XmlAttribute(name = "AggrementID")
    protected String aggrementID;

    /**
     * Gets the value of the ipbic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPBIC() {
        return ipbic;
    }

    /**
     * Sets the value of the ipbic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPBIC(String value) {
        this.ipbic = value;
    }

    /**
     * Gets the value of the aggrementID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAggrementID() {
        return aggrementID;
    }

    /**
     * Sets the value of the aggrementID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAggrementID(String value) {
        this.aggrementID = value;
    }

}

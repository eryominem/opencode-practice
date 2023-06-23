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
 * Комплексный тип для электронных сообщений. Содержит реквизит EDSender.
 * 
 * <p>Java class for ESWithEDSender complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ESWithEDSender"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:cbr-ru:ed:v2.0}ESWithMandatoryEDReceiver"&gt;
 *       &lt;attribute name="EDSender" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}EDDrawerIDType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESWithEDSender")
public class ESWithEDSender
    extends ESWithMandatoryEDReceiver
{

    @XmlAttribute(name = "EDSender", required = true)
    protected String edSender;

    /**
     * Gets the value of the edSender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEDSender() {
        return edSender;
    }

    /**
     * Sets the value of the edSender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEDSender(String value) {
        this.edSender = value;
    }

}
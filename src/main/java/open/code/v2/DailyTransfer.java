//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.17 at 07:21:09 PM GST 
//


package open.code.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Balance Sweeping Event.
 * 
 * <p>Java class for DailyTransfer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DailyTransfer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="TimeTransfer" type="{urn:cbr-ru:ed:leaftypes:v2.0}TimeType"/&gt;
 *         &lt;element name="EventTransfer" type="{urn:cbr-ru:ed:v2.0}EventTransfer"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DailyTransfer", propOrder = {
    "timeTransfer",
    "eventTransfer"
})
public class DailyTransfer {

    @XmlElement(name = "TimeTransfer")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar timeTransfer;
    @XmlElement(name = "EventTransfer")
    protected EventTransfer eventTransfer;

    /**
     * Gets the value of the timeTransfer property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeTransfer() {
        return timeTransfer;
    }

    /**
     * Sets the value of the timeTransfer property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeTransfer(XMLGregorianCalendar value) {
        this.timeTransfer = value;
    }

    /**
     * Gets the value of the eventTransfer property.
     * 
     * @return
     *     possible object is
     *     {@link EventTransfer }
     *     
     */
    public EventTransfer getEventTransfer() {
        return eventTransfer;
    }

    /**
     * Sets the value of the eventTransfer property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventTransfer }
     *     
     */
    public void setEventTransfer(EventTransfer value) {
        this.eventTransfer = value;
    }

}

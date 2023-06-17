//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.17 at 07:21:09 PM GST 
//


package open.code.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Masterdata or Authorized senders.
 * 
 * <p>Java class for UFCFMD complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UFCFMD"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UFCFRecord" type="{urn:cbr-ru:ed:v2.0}UFCFRecord" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UFCFMD", propOrder = {
    "ufcfRecord"
})
public class UFCFMD {

    @XmlElement(name = "UFCFRecord", required = true)
    protected List<UFCFRecord> ufcfRecord;

    /**
     * Gets the value of the ufcfRecord property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ufcfRecord property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUFCFRecord().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UFCFRecord }
     * 
     * 
     */
    public List<UFCFRecord> getUFCFRecord() {
        if (ufcfRecord == null) {
            ufcfRecord = new ArrayList<UFCFRecord>();
        }
        return this.ufcfRecord;
    }

}

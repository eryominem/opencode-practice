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
 * Authorized Claim Authors List For Indirect Participant.
 * 
 * <p>Java class for AuthorizedClaimAuthorsForIP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthorizedClaimAuthorsForIP"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AuthorizedClaimAuthorsListForIP" type="{urn:cbr-ru:ed:v2.0}AuthorizedClaimAuthorsListForIP" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthorizedClaimAuthorsForIP", propOrder = {
    "authorizedClaimAuthorsListForIP"
})
public class AuthorizedClaimAuthorsForIP {

    @XmlElement(name = "AuthorizedClaimAuthorsListForIP", required = true)
    protected List<AuthorizedClaimAuthorsListForIP> authorizedClaimAuthorsListForIP;

    /**
     * Gets the value of the authorizedClaimAuthorsListForIP property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authorizedClaimAuthorsListForIP property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthorizedClaimAuthorsListForIP().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuthorizedClaimAuthorsListForIP }
     * 
     * 
     */
    public List<AuthorizedClaimAuthorsListForIP> getAuthorizedClaimAuthorsListForIP() {
        if (authorizedClaimAuthorsListForIP == null) {
            authorizedClaimAuthorsListForIP = new ArrayList<AuthorizedClaimAuthorsListForIP>();
        }
        return this.authorizedClaimAuthorsListForIP;
    }

}

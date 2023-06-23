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
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Базовый комплексный тип для обмена с ФК.
 * 
 * <p>Java class for EDWithDeclaration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EDWithDeclaration"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:cbr-ru:ed:v2.0}ED"&gt;
 *       &lt;attribute name="DeclarationDate" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}DateType" /&gt;
 *       &lt;attribute name="DeclarationNo" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}DeclarationNoType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EDWithDeclaration")
public class EDWithDeclaration
    extends ED
{

    @XmlAttribute(name = "DeclarationDate", required = true)
    protected XMLGregorianCalendar declarationDate;
    @XmlAttribute(name = "DeclarationNo", required = true)
    protected BigInteger declarationNo;

    /**
     * Gets the value of the declarationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeclarationDate() {
        return declarationDate;
    }

    /**
     * Sets the value of the declarationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeclarationDate(XMLGregorianCalendar value) {
        this.declarationDate = value;
    }

    /**
     * Gets the value of the declarationNo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDeclarationNo() {
        return declarationNo;
    }

    /**
     * Sets the value of the declarationNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDeclarationNo(BigInteger value) {
        this.declarationNo = value;
    }

}
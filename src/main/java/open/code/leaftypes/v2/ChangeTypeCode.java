//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.17 at 07:21:09 PM GST 
//


package open.code.leaftypes.v2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChangeTypeCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ChangeTypeCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NCHG"/&gt;
 *     &lt;enumeration value="CHNG"/&gt;
 *     &lt;enumeration value="ADDD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ChangeTypeCode", namespace = "urn:cbr-ru:ed:leaftypes:v2.0")
@XmlEnum
public enum ChangeTypeCode {

    NCHG,
    CHNG,
    ADDD;

    public String value() {
        return name();
    }

    public static ChangeTypeCode fromValue(String v) {
        return valueOf(v);
    }

}

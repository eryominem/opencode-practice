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
 * <p>Java class for LimitChangeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LimitChangeType"&gt;
 *   &lt;restriction base="{urn:cbr-ru:ed:basetypes:v2.0}CodeCategory"&gt;
 *     &lt;enumeration value="SETL"/&gt;
 *     &lt;enumeration value="DELL"/&gt;
 *     &lt;enumeration value="STND"/&gt;
 *     &lt;enumeration value="DLND"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "LimitChangeType", namespace = "urn:cbr-ru:ed:leaftypes:v2.0")
@XmlEnum
public enum LimitChangeType {

    SETL,
    DELL,
    STND,
    DLND;

    public String value() {
        return name();
    }

    public static LimitChangeType fromValue(String v) {
        return valueOf(v);
    }

}

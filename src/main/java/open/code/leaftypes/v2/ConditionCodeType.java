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
 * <p>Java class for ConditionCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConditionCodeType"&gt;
 *   &lt;restriction base="{urn:cbr-ru:ed:basetypes:v2.0}CodeCategory"&gt;
 *     &lt;enumeration value="RSRV"/&gt;
 *     &lt;enumeration value="ERCP"/&gt;
 *     &lt;enumeration value="COVR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ConditionCodeType", namespace = "urn:cbr-ru:ed:leaftypes:v2.0")
@XmlEnum
public enum ConditionCodeType {

    RSRV,
    ERCP,
    COVR;

    public String value() {
        return name();
    }

    public static ConditionCodeType fromValue(String v) {
        return valueOf(v);
    }

}
package open.code.enums;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum RequestCodeType {

    FIRR,
    SIRR,
    PROF;

    public String value() {
        return name();
    }

    public static RequestCodeType fromValue(String v) {
        return valueOf(v);
    }

}
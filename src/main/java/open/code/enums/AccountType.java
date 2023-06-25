package open.code.enums;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum AccountType {

    BANA,
    CBRA,
    CRSA,
    TRSA,
    CLRA,
    EPGA,
    EPSA,
    GARA,
    TRUA,
    UTRA,
    CLAC;

    public String value() {
        return name();
    }

    public static AccountType fromValue(String v) {
        return valueOf(v);
    }

}

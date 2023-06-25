package open.code.enums;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum AccountStatusType {

    ACAC,
    ACDL;

    public String value() {
        return name();
    }

    public static AccountStatusType fromValue(String v) {
        return valueOf(v);
    }

}

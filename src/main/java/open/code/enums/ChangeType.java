package open.code.enums;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum ChangeType {

    ADDD,
    CHGD,
    NCNG,
    DLTD;

    public String value() {
        return name();
    }

    public static ChangeType fromValue(String v) {
        return valueOf(v);
    }
}

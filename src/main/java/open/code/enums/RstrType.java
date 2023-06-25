package open.code.enums;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum RstrType {
    NORS,

    URRS,
    LWRS,

    LMRS,

    CLRS,

    FPRS,
    MRTR,
    SDRS;

    public String value() {
        return name();
    }

    public static RstrType fromValue(String v) {
        return valueOf(v);
    }

}
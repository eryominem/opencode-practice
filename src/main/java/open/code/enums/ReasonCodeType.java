package open.code.enums;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum ReasonCodeType {
    ACCH,
    AICH,
    ALCH,
    ANTC,
    APPA,
    RIRA,
    RIRP,
    RMAA,
    RMVA,
    RQST,
    SMON,
    SOBD,
    SPOF,
    UIRA,
    UIRP,
    ARRD,
    ARRM,
    ARRS,
    EOBD,
    EOCC,
    ICLD,
    ICLM,
    ICLS,
    PCHD,
    CSCH,
    NSCH,
    FCBD,
    CIBD,
    PPAD;

    public String value() {
        return name();
    }

    public static ReasonCodeType fromValue(String v) {
        return valueOf(v);
    }

}

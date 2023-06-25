package open.code.enums;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum ParticipantStatusType {

    PSAC,
    PSDL;

    public String value() {
        return name();
    }

    public static ParticipantStatusType fromValue(String v) {
        return valueOf(v);
    }

}
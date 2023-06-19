package open.code.dto;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SWBICS", namespace = "urn:cbr-ru:ed:v2.0")
public class SWBICSDto {
    @XmlAttribute(name = "SWBIC")
    private String swbic;

    @XmlAttribute(name = "DefaultSWBIC")
    private boolean defaultSWBIC;
}

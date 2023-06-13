package open.code.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import open.code.adapter.LocalDateAdapter;
import open.code.adapter.LocalDateTimeAdapter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "ED807", namespace = "urn:cbr-ru:ed:v2.0")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String fileName;

    @XmlAttribute(name = "EDNo")
    private String eDNo;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "EDDate")
    private LocalDate eDDate;

    @XmlAttribute(name = "EDAuthor")
    private String eDAuthor;

    @XmlAttribute(name = "EDReceiver")
    private String eDReceiver;

    @XmlAttribute(name = "CreationReason")
    private String creationReason;

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @XmlAttribute(name = "CreationDateTime")
    private LocalDateTime creationDateTime;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    @XmlAttribute(name = "InfoTypeCode")
    private String infoTypeCode;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "BusinessDay")
    private LocalDate businessDay;

    @XmlAttribute(name = "DirectoryVersion")
    private int directoryVersion;

    private String createdBy;

    @XmlElement(name = "BICDirectoryEntry", namespace = "urn:cbr-ru:ed:v2.0")
    @OneToMany(mappedBy = "bankMessage", cascade = CascadeType.ALL)
    private List<BicDirectoryEntry> bicDirectoryEntries;
}
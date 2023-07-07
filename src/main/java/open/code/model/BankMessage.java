package open.code.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import open.code.enums.ReasonCodeType;
import open.code.enums.RequestCodeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String fileName;

    private String eDNo;

    private LocalDate eDDate;

    private String eDAuthor;

    private String eDReceiver;

    @Enumerated(EnumType.STRING)
    private ReasonCodeType creationReason;

    private LocalDateTime creationDateTime;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    @Enumerated(EnumType.STRING)
    private RequestCodeType infoTypeCode;

    private LocalDate businessDay;

    private int directoryVersion;

    private String createdBy;

    private String deletedBy;

    private LocalDateTime deletedAt;

    @JsonIgnore
    private boolean deleted;

    @OneToMany(mappedBy = "bankMessage", cascade = CascadeType.ALL)
    private List<BicDirectoryEntry> bicDirectoryEntries;

    @OneToOne(mappedBy = "bankMessage", cascade = CascadeType.ALL)
    private Directory directory;
}
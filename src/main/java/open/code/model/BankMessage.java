package open.code.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @NotNull
    private String title;

    @NotNull
    private String fileName;

    private String eDNo;

    private LocalDate eDDate;

    private String eDAuthor;

    private String eDReceiver;

    private String creationReason;

    private LocalDateTime creationDateTime;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    private String infoTypeCode;

    private LocalDate businessDay;

    private int directoryVersion;

    private String createdBy;

    @OneToMany(mappedBy = "bankMessage", cascade = CascadeType.ALL)
    private List<BicDirectoryEntry> bicDirectoryEntries;
}
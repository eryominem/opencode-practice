package open.code.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    private LocalDate validityStart;

    private LocalDate validityEnd;

    @JsonIgnore
    private String directoryType;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private String createdBy;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private String updatedBy;

    @JsonIgnore
    private LocalDateTime deletedAt;

    private String deletedBy;

    @JsonIgnore
    private boolean deleted;

}

package open.code.model.Directory;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccountStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    private LocalDate validityStart;

    private LocalDate validityEnd;

    private LocalDateTime createDateTime;

    private String usernameCreate;

    private LocalDateTime updateDateTime;

    private String usernameUpdate;
}

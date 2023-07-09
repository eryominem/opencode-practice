package open.code.dto.ed807_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankMessageFilterDto {
    private String title;

    private LocalDate date1;

    private LocalDate date2;

    private Boolean deleted;
}

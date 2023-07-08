package open.code.dto.bic_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BicDirectoryFilterDto {
    private String bic;

    private String nameP;

    private String ptType;

    private Long msgId;
}

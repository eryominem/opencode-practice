package open.code.controller;

import open.code.dto.bic_dto.BicDirectoryFilterDto;
import open.code.dto.bic_dto.PayerDto;
import open.code.service.bnk_msg.BicDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bics")
public class BicDirectoryController {
    private final BicDirectoryService bicDirectoryService;

    @Autowired
    public BicDirectoryController(BicDirectoryService bicDirectoryService) {
        this.bicDirectoryService = bicDirectoryService;
    }

    @GetMapping("/payers")
    public Page<PayerDto> getPayers(@RequestParam("msgId") Long msgId,
                                    @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        return bicDirectoryService.transformBicDirectoriesToPayers(msgId, page);
    }

    @PostMapping("/filter")
    public Page<PayerDto> getPayersByFilter(@RequestBody BicDirectoryFilterDto bicDirectoryFilterDto,
                                            @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        return bicDirectoryService.findAllPayersByFilter(bicDirectoryFilterDto, page);
    }

    @GetMapping("/count")
    public long getCount(@RequestParam("msgId") Long msgId) {
        return bicDirectoryService.countAll(msgId);
    }
}

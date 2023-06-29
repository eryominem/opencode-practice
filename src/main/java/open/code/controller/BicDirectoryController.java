package open.code.controller;

import open.code.dto.PayerDto;
import open.code.service.bnk_msg.BicDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bics")
public class BicDirectoryController {
    private final BicDirectoryService bicDirectoryService;

    @Autowired
    public BicDirectoryController(BicDirectoryService bicDirectoryService) {
        this.bicDirectoryService = bicDirectoryService;
    }

    @GetMapping("/count")
    public long getCount(@RequestParam("id") Long id) {
        return bicDirectoryService.countAll(id);
    }

    @GetMapping("/filter")
    public List<PayerDto> getPayersByFilter(@RequestParam(value = "bic", required = false) String bic,
                                            @RequestParam(value = "nameP", required = false) String nameP,
                                            @RequestParam(value = "ptType", required = false) String ptType,
                                            @RequestParam(value = "msgId") Long id) {
        return bicDirectoryService.findAllPayersByFilter(bic, nameP, ptType, id);
    }

    @GetMapping("/payers")
    public List<PayerDto> getPayers(@RequestParam("msgId") Long msgId, @RequestParam("bicId") Long bicId) {
        return bicDirectoryService.transformBicDirectoriesToPayers(msgId, bicId);
    }
}

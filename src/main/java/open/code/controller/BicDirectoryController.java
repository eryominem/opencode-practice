package open.code.controller;

import open.code.dto.PayerDto;
import open.code.dto.SWBICSDto;
import open.code.model.SWBICS;
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

    @GetMapping("/payers")
    public List<PayerDto> getPayers(@RequestParam("msgId") Long msgId, @RequestParam("bicId") Long bicId) {
        return bicDirectoryService.transformBicDirectoriesToPayers(msgId, bicId);
    }

    @GetMapping("/swbics")
    public List<SWBICSDto> getSWBICS(@RequestParam("msgId") Long msgId, @RequestParam("bicId") Long bicId) {
        return bicDirectoryService.transformSWBICSToDto(msgId, bicId);
    }
}

package open.code.controller;

import open.code.dto.BicDirectoryFilterDto;
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

    @GetMapping("/payers")
    public List<PayerDto> getPayers(@RequestParam("msgId") Long msgId, @RequestParam("bicId") Long bicId) {
        return bicDirectoryService.transformBicDirectoriesToPayers(msgId, bicId);
    }

    @PostMapping("/filter")
    public List<PayerDto> getPayersByFilter(@RequestBody BicDirectoryFilterDto bicDirectoryFilterDto) {
        return bicDirectoryService.findAllPayersByFilter(bicDirectoryFilterDto);
    }

    @GetMapping("/count")
    public long getCount(@RequestParam("msgId") Long msgId) {
        return bicDirectoryService.countAll(msgId);
    }
}

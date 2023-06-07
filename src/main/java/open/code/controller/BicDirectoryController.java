package open.code.controller;

import open.code.dto.PayerDto;
import open.code.service.BicDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bics")
public class BicDirectoryController {
    private final BicDirectoryService bicDirectoryService;

    @Autowired
    public BicDirectoryController(BicDirectoryService bicDirectoryService) {
        this.bicDirectoryService = bicDirectoryService;
    }

    @PostMapping
    public void createPayer(@RequestParam("msgId") Long id,
                            @RequestBody PayerDto payerDto) {

    }

    @GetMapping
    public List<PayerDto> getPayers(@RequestParam("msgId") Long id) {
        return bicDirectoryService.transformBicDirectoriesToPayers(id);
    }

}

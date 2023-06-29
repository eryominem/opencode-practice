package open.code.controller;

import open.code.dto.SWBICSDto;
import open.code.service.bnk_msg.SWBICSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/swbics")
public class SWBICSController {
    private final SWBICSService swbicsService;

    @Autowired
    public SWBICSController(SWBICSService swbicsService) {
        this.swbicsService = swbicsService;
    }

    @GetMapping
    public List<SWBICSDto> getAll(@RequestParam("id") Long id) {
        return swbicsService.findAllSWBICSByBicId(id);
    }
}

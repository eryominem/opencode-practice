package open.code.controller;

import open.code.dto.AccRstrListDto;
import open.code.service.bnk_msg.AccRstrListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accRstr")
public class AccRstrListController {

    private final AccRstrListService rstrListService;

    public AccRstrListController(AccRstrListService rstrListService) {
        this.rstrListService = rstrListService;
    }

    @GetMapping
    public List<AccRstrListDto> getAll(@RequestParam("id") Long id) {
        return rstrListService.getAllByAccountId(id);
    }
}

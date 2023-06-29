package open.code.controller;

import open.code.dto.RstrListDto;
import open.code.service.bnk_msg.RstrListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rstrList")
public class RstrListController {

    private final RstrListService rstrListService;

    @Autowired
    public RstrListController(RstrListService rstrListService) {
        this.rstrListService = rstrListService;
    }

    @GetMapping
    public RstrListDto get(@RequestParam("id") Long id) {
        return rstrListService.getRstrListByParticipantId(id);
    }
}

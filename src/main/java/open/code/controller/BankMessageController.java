package open.code.controller;

import open.code.dto.BankMessageDto;
import open.code.service.bnk_msg.BankMessageService;
import open.code.service.bnk_msg.EntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/ed807")
public class BankMessageController {
    private final EntityService entityService;
    private final BankMessageService bankMessageService;

    public BankMessageController(EntityService entityService, BankMessageService bankMessageService) {
        this.entityService = entityService;
        this.bankMessageService = bankMessageService;
    }

    @PostMapping
    public ResponseEntity<?> uploadMessage(@RequestPart("file") MultipartFile file,
                                           @RequestParam("title") Optional<String> title) {
        return entityService.saveEntitiesFromXml(file, title);
    }

    @GetMapping
    public List<BankMessageDto> getMessages() {
        return bankMessageService.transformBankMessageToDto();
    }
}

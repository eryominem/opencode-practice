package open.code.controller;

import open.code.service.BankMessageService;
import open.code.service.EntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/ed807")
public class BankMessageController {
    private final EntityService entityService;
    private final BankMessageService bankMessageService;

    public BankMessageController(EntityService entityService,
                                 BankMessageService bankMessageService) {
        this.entityService = entityService;
        this.bankMessageService = bankMessageService;
    }

   @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestPart("file") MultipartFile file) {
        return entityService.saveEntitiesFromXml(file);
    }

}
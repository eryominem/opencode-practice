package open.code.controller;

import open.code.model.BankMessage;
import open.code.service.BankMessageService;
import open.code.service.EntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/ed807")
public class BankMessageController {
    private final EntityService entityService;
    private final BankMessageService bankMessageService;

    public BankMessageController(EntityService entityService, BankMessageService bankMessageService) {
        this.entityService = entityService;
        this.bankMessageService = bankMessageService;
    }

    @PostMapping
    public ResponseEntity<?> upload(@RequestPart("file") MultipartFile file,
                                    @RequestParam("title") Optional<String> title) {
        if (title.isPresent()) {
            return entityService.saveEntitiesFromXml(file, title.get());
        } else {
            return entityService.saveEntitiesFromXml(file, file.getOriginalFilename());
        }
    }

    /*@GetMapping
    public List<BankMessage> getAll() {
        return bankMessageService.getAllMessages();
    }*/

    /*@GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {

    }*/
}

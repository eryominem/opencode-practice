package open.code.controller;

import open.code.dto.BankMessageFilterDto;
import open.code.dto.BankMsgViewDto;
import open.code.service.bnk_msg.BankMessageService;
import open.code.service.bnk_msg.EntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
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

    @GetMapping(value = "/filter")
    public List<BankMsgViewDto> messageFilter(@RequestBody BankMessageFilterDto bankMessageFilterDto) {
        return bankMessageService.findBankMessageByFilter(bankMessageFilterDto);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadMessage(@RequestPart("file") MultipartFile file,
                                           @RequestParam("title") Optional<String> title) {
        return entityService.saveEntitiesFromXml(file, title);
    }

    @GetMapping
    public List<BankMsgViewDto> getMessages() {
        return bankMessageService.transformBankMsgToViewDto();
    }

    @PatchMapping("/{id}")
    public BankMsgViewDto recovery(@PathVariable("id") Long id) {
        return bankMessageService.recoveryById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return bankMessageService.deleteById(id);
    }
}

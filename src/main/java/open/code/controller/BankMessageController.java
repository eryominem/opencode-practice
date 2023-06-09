package open.code.controller;

import open.code.dto.ed807_dto.BankMessageFilterDto;
import open.code.dto.ed807_dto.BankMsgViewDto;
import open.code.parser.CBRParser;
import open.code.service.bnk_msg.BankMessageService;
import open.code.service.bnk_msg.EntityService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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
    private final CBRParser cbrParser;

    public BankMessageController(EntityService entityService, BankMessageService bankMessageService, CBRParser cbrParser) {
        this.entityService = entityService;
        this.bankMessageService = bankMessageService;
        this.cbrParser = cbrParser;
    }

    @PostMapping(value = "/filter")
    public Page<BankMsgViewDto> messageFilter(@RequestBody BankMessageFilterDto bankMessageFilterDto,
                                              @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        return bankMessageService.findBankMessageByFilter(bankMessageFilterDto, page);
    }

    @GetMapping("/actualization")
    public ResponseEntity<?> uploadActualFile() {
        return entityService.saveEntitiesFromXml(cbrParser.download());
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public BankMsgViewDto delete(@PathVariable("id") Long id) {
        return bankMessageService.deleteById(id);
    }
}

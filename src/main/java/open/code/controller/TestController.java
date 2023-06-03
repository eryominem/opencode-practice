package open.code.controller;

import open.code.model.BankMessage;
import open.code.repository.AccountRepository;
import open.code.repository.BankMessageRepository;
import open.code.repository.BicDirectoryEntryRepository;
import open.code.repository.ParticipantInfoRepository;
import open.code.service.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class TestController {

    private final Converter converter;

    private final BankMessageRepository bankMessageRepository;

    private final AccountRepository accountRepository;

    private final BicDirectoryEntryRepository bicDirectoryEntryRepository;

    private final ParticipantInfoRepository participantInfoRepository;


    @Autowired
    public TestController(Converter converter, BankMessageRepository bankMessageRepository, AccountRepository accountRepository, BicDirectoryEntryRepository bicDirectoryEntryRepository, ParticipantInfoRepository participantInfoRepository) {
        this.converter = converter;
        this.bankMessageRepository = bankMessageRepository;
        this.accountRepository = accountRepository;
        this.bicDirectoryEntryRepository = bicDirectoryEntryRepository;
        this.participantInfoRepository = participantInfoRepository;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> add(@RequestParam("file") MultipartFile multipartFile) {
        converter.parseXmlAndSaveToDatabase(multipartFile);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

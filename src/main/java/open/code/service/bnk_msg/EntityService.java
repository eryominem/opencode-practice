package open.code.service.bnk_msg;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import open.code.dto.BankMessageDto;
import open.code.mapper.BankMessageMapper;
import open.code.model.*;
import open.code.repository.bnk_msg.BankMessageRepository;
import open.code.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Log4j2
@Service
public class EntityService {
    private final BankMessageRepository bankMessageRepository;
    private final BankMessageMapper bankMessageMapper;

    @Autowired
    public EntityService(BankMessageRepository bankMessageRepository, BankMessageMapper bankMessageMapper) {
        this.bankMessageRepository = bankMessageRepository;
        this.bankMessageMapper = bankMessageMapper;
    }

    public ResponseEntity<?> saveEntitiesFromXml(MultipartFile file, Optional<String> title) {
        if (file.isEmpty()) {
            log.warn("No file uploaded");
            return ResponseEntity.badRequest().body("No file uploaded");
        }
        try {
            File xmlFile = convertMultipartFileToFile(file);
            JAXBContext jaxbContext = JAXBContext.newInstance(BankMessageDto.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            BankMessageDto bankMessageDto = (BankMessageDto) unmarshaller.unmarshal(xmlFile);
            if (title.isPresent()) {
                bankMessageDto.setTitle(title.get());
            } else {
                bankMessageDto.setTitle(xmlFile.getName());
            }
            bankMessageDto.setCreatedBy(SecurityUtil.extractNameCurrentUser());
            bankMessageDto.setFileName(xmlFile.getName());
            saveEntitiesFromXml(transformDtoToBankMessage(bankMessageDto));
            log.info("File uploaded and entities saved successfully");
            return ResponseEntity.ok("File uploaded and entities saved successfully");
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            log.error("Failed to process the uploaded file");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process the uploaded file");
        }
    }

    @Transactional(rollbackOn = MethodArgumentNotValidException.class)
    public void saveEntitiesFromXml(BankMessage bankMessage) {
        if (bankMessage == null) {
            log.error("Bank message is null");
            return;
        }
        List<BicDirectoryEntry> bicDirectoryEntries = bankMessage.getBicDirectoryEntries();
        if (!CollectionUtils.isEmpty(bicDirectoryEntries)) {
            for (BicDirectoryEntry entry : bicDirectoryEntries) {
                entry.setBankMessage(bankMessage);
                List<SWBICS> swbicsList = entry.getSwbics();
                if (swbicsList != null) {
                    for (SWBICS swbics : swbicsList) {
                        swbics.setBicDirectoryEntry(entry);
                    }
                }
                ParticipantInfo participantInfo = entry.getParticipantInfo();
                if (participantInfo != null) {
                    RstrList rstrList = participantInfo.getRstrList();
                    if (rstrList != null) {
                        rstrList.setParticipantInfo(participantInfo);
                    }
                    participantInfo.setBicDirectoryEntry(entry);
                }
                List<Account> accounts = entry.getAccounts();
                if (!CollectionUtils.isEmpty(accounts)) {
                    for (Account account : accounts) {
                        account.setBicDirectoryEntry(entry);

                        List<AccRstrList> accRstrList = account.getAccRstrLists();
                        if (accRstrList != null) {
                            for (AccRstrList accRstrLists : accRstrList) {
                                accRstrLists.setAccount(account);
                            }
                        }
                    }
                }
            }
        }
        log.info("Bank message saved successfully");
        bankMessageRepository.saveAndFlush(bankMessage);
    }

    private BankMessage transformDtoToBankMessage(@Valid BankMessageDto bankMessageDto) {
        return bankMessageMapper.toModel(bankMessageDto);
    }

    private File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileCopyUtils.copy(multipartFile.getBytes(), file);
        log.info("File converted successfully");
        return file;
    }
}
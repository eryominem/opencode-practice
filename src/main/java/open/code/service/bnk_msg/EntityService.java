package open.code.service.bnk_msg;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import open.code.dto.ED807CreationDto;
import open.code.model.*;
import open.code.repository.bnk_msg.BankMessageRepository;
import open.code.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.FileCopyUtils;
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

    @Autowired
    public EntityService(BankMessageRepository bankMessageRepository) {
        this.bankMessageRepository = bankMessageRepository;
    }

    @Transactional
    public ResponseEntity<?> saveEntitiesFromXml(MultipartFile file, Optional<String> title) {
        if (file.isEmpty()) {
            log.warn("No file uploaded");
            return ResponseEntity.badRequest().body("No file uploaded");
        }
        try {
            File xmlFile = convertMultipartFileToFile(file);
            JAXBContext jaxbContext = JAXBContext.newInstance(ED807CreationDto.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            ED807CreationDto ed807CreationDto = (ED807CreationDto) unmarshaller.unmarshal(xmlFile);
            if (title.isPresent()) {
                ed807CreationDto.setTitle(title.get());
            } else {
                ed807CreationDto.setTitle(xmlFile.getName());
            }
            ed807CreationDto.setCreatedBy(SecurityUtil.extractNameCurrentUser());
            ed807CreationDto.setFileName(xmlFile.getName());
            saveEntitiesFromXml(builder(ed807CreationDto));
            System.out.println(ed807CreationDto);
            log.info("File uploaded and entities saved successfully");
            return ResponseEntity.ok("File uploaded and entities saved successfully");
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            log.error("Failed to process the uploaded file");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process the uploaded file");
        }
    }

    private BankMessage builder(ED807CreationDto ed807CreationDto){
        return BankMessage.builder()
                .title(ed807CreationDto.getTitle())
                .fileName(ed807CreationDto.getFileName())
                .createdBy(ed807CreationDto.getCreatedBy())
                .eDNo(ed807CreationDto.getEDNo())
                .eDDate(ed807CreationDto.getEDDate())
                .eDAuthor(ed807CreationDto.getEDAuthor())
                .eDReceiver(ed807CreationDto.getEDReceiver())
                .creationReason(ed807CreationDto.getCreationReason())
                .creationDateTime(ed807CreationDto.getCreationDateTime())
                .infoTypeCode(ed807CreationDto.getInfoTypeCode())
                .businessDay(ed807CreationDto.getBusinessDay())
                .directoryVersion(ed807CreationDto.getDirectoryVersion())
                .bicDirectoryEntries(ed807CreationDto.getBicDirectoryEntries())
                .build();
    }

    @Transactional
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

    private File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileCopyUtils.copy(multipartFile.getBytes(), file);
        log.info("File converted successfully");
        return file;
    }
}
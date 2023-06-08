package open.code.service.bnk_msg;

import jakarta.transaction.Transactional;
import open.code.model.*;
import open.code.repository.bnk_msg.AccountRepository;
import open.code.repository.bnk_msg.BankMessageRepository;
import open.code.repository.bnk_msg.BicDirectoryEntryRepository;
import open.code.repository.bnk_msg.ParticipantInfoRepository;
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

@Service
public class EntityService {
    private final BankMessageRepository bankMessageRepository;
    private final BicDirectoryEntryRepository bicDirectoryEntryRepository;
    private final ParticipantInfoRepository participantInfoRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public EntityService(BankMessageRepository bankMessageRepository,
                         BicDirectoryEntryRepository bicDirectoryEntryRepository,
                         ParticipantInfoRepository participantInfoRepository,
                         AccountRepository accountRepository) {
        this.bankMessageRepository = bankMessageRepository;
        this.bicDirectoryEntryRepository = bicDirectoryEntryRepository;
        this.participantInfoRepository = participantInfoRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public ResponseEntity<?> saveEntitiesFromXml(MultipartFile file, Optional<String> title) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No file uploaded");
        }
        try {
            File xmlFile = convertMultipartFileToFile(file);
            JAXBContext jaxbContext = JAXBContext.newInstance(BankMessage.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            BankMessage bankMessage = (BankMessage) unmarshaller.unmarshal(xmlFile);

            if (title.isPresent()) {
                bankMessage.setTitle(title.get());
            } else {
                bankMessage.setTitle(xmlFile.getName());
            }

            bankMessage.setFileName(xmlFile.getName());
            saveEntitiesFromXml(bankMessage);
            return ResponseEntity.ok("File uploaded and entities saved successfully");
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process the uploaded file");
        }
    }

    @Transactional
    public void saveEntitiesFromXml(BankMessage bankMessage) {
        if (bankMessage != null) {
            if (bankMessage.getInitialEDS() != null) {
                List<InitialED> initialEDS = bankMessage.getInitialEDS();
                for (InitialED initialED : initialEDS)
                    initialED.setBankMessage(bankMessage);
            }
            if (bankMessage.getPartInfos() != null) {
                List<PartInfo> partInfos = bankMessage.getPartInfos();
                for (PartInfo partInfo : partInfos)
                    partInfo.setBankMessage(bankMessage);
            }
            List<BicDirectoryEntry> bicDirectoryEntries = bankMessage.getBicDirectoryEntries();
            if (!CollectionUtils.isEmpty(bicDirectoryEntries)) {
                for (BicDirectoryEntry entry : bicDirectoryEntries) {
                    entry.setBankMessage(bankMessage);
                    if (entry.getSwbics() != null) {
                        List<SWBICS> swbicsList = entry.getSwbics();
                        for (SWBICS swbics : swbicsList) {
                            swbics.setBicDirectoryEntry(entry);
                        }
                    }
                    ParticipantInfo participantInfo = entry.getParticipantInfo();
                    if (participantInfo != null) {
                        if (participantInfo.getRstrList() != null) {
                            RstrList rstrList = participantInfo.getRstrList();
                            rstrList.setParticipantInfo(participantInfo);
                        }
                        participantInfo.setBicDirectoryEntry(entry);
                    }
                    List<Account> accounts = entry.getAccounts();
                    if (!CollectionUtils.isEmpty(accounts)) {
                        for (Account account : accounts) {
                            account.setBicDirectoryEntry(entry);
                            if (account.getAccRstrLists() != null) {
                                List<AccRstrList> accRstrList = account.getAccRstrLists();
                                for (AccRstrList accRstrLists : accRstrList) {
                                    accRstrLists.setAccount(account);
                                }
                            }
                        }
                    }
                }
            }
            bankMessageRepository.save(bankMessage);
        }
    }

    private File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileCopyUtils.copy(multipartFile.getBytes(), file);
        return file;
    }
}
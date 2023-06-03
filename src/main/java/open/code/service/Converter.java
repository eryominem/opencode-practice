package open.code.service;

import open.code.model.Account;
import open.code.model.BankMessage;
import open.code.model.BicDirectoryEntry;
import open.code.model.ParticipantInfo;
import open.code.repository.AccountRepository;
import open.code.repository.BankMessageRepository;
import open.code.repository.BicDirectoryEntryRepository;
import open.code.repository.ParticipantInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.stream.Collectors;

@Service
public class Converter {

    private final BankMessageRepository bankMessageRepository;

    private final AccountRepository accountRepository;

    private final BicDirectoryEntryRepository bicDirectoryEntryRepository;

    private final ParticipantInfoRepository participantInfoRepository;

    @Autowired
    public Converter(BankMessageRepository bankMessageRepository, AccountRepository accountRepository, BicDirectoryEntryRepository bicDirectoryEntryRepository, ParticipantInfoRepository participantInfoRepository) {
        this.bankMessageRepository = bankMessageRepository;
        this.accountRepository = accountRepository;
        this.bicDirectoryEntryRepository = bicDirectoryEntryRepository;
        this.participantInfoRepository = participantInfoRepository;
    }

    public void parseXmlAndSaveToDatabase(MultipartFile multipartFile) {
        try {
            File file = File.createTempFile("temp", multipartFile.getOriginalFilename());
            FileCopyUtils.copy(multipartFile.getBytes(), file);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String body = br.lines().collect(Collectors.joining());
            StringReader reader = new StringReader(body);
            JAXBContext context = JAXBContext.newInstance(BankMessage.class, BicDirectoryEntry.class, Account.class, ParticipantInfo.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            BankMessage bankMessage = (BankMessage) unmarshaller.unmarshal(reader);
            System.out.println(bankMessage);
            bankMessageRepository.save(bankMessage);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}

package open.code.service;

import open.code.model.BankMessage;
import open.code.repository.BankMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.stream.Collectors;

@Service
public class Converter {

    private final BankMessageRepository bankMessageRepository;

    @Autowired
    public Converter(BankMessageRepository bankMessageRepository) {
        this.bankMessageRepository = bankMessageRepository;
    }

    public void parseXmlAndSaveToDatabase(File xmlFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(xmlFile));
            String body = br.lines().collect(Collectors.joining());
            StringReader reader = new StringReader(body);
            JAXBContext context = JAXBContext.newInstance(BankMessage.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            BankMessage bankMessage = (BankMessage) unmarshaller.unmarshal(reader);
            bankMessageRepository.save(bankMessage);
        } catch (JAXBException | FileNotFoundException e) {
            System.out.println("hui");
            e.printStackTrace();
        }
    }
}

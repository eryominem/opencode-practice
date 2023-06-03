package open.code.controller;

import open.code.model.BankMessage;
import open.code.repository.BankMessageRepository;
import open.code.service.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


@RestController
public class TestController {

    private final Converter converter;

    private final BankMessageRepository bankMessageRepository;


    @Autowired
    public TestController(Converter converter, BankMessageRepository bankMessageRepository) {
        this.converter = converter;
        this.bankMessageRepository = bankMessageRepository;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> add(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        File file = File.createTempFile("temp", multipartFile.getOriginalFilename());
        FileCopyUtils.copy(multipartFile.getBytes(), file);
        converter.parseXmlAndSaveToDatabase(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/register2")
    public ResponseEntity<?> add(@RequestBody BankMessage bankMessage) {
        bankMessageRepository.save(bankMessage);
        System.out.println(bankMessage.getEDNo());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

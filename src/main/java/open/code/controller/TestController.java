package open.code.controller;

import open.code.service.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class TestController {

    private final Converter converter;

    @Autowired
    public TestController(Converter converter) {
        this.converter = converter;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> add(@RequestParam("file") MultipartFile multipartFile) {
        converter.parseXmlAndSaveToDatabase(multipartFile);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

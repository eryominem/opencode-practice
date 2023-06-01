package open.code.controller;

import open.code.model.BicDirectoryEntry;
import open.code.repository.BicDirectoryEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    private final BicDirectoryEntryRepository bicDirectoryEntryRepository;

    @Autowired
    public TestController(BicDirectoryEntryRepository bicDirectoryEntryRepository) {
        this.bicDirectoryEntryRepository = bicDirectoryEntryRepository;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> add(@RequestBody BicDirectoryEntry bicDirectoryEntries) {
        bicDirectoryEntryRepository.save(bicDirectoryEntries);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

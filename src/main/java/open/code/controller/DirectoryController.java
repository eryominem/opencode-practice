package open.code.controller;

import open.code.model.Directory;
import open.code.dto.DirectoryDto;
import open.code.service.directory.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directories")
public class DirectoryController {
    private final DirectoryService directoryService;

    @Autowired
    public DirectoryController(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @PostMapping("/upload/{type}")
    public ResponseEntity<Directory> add(@RequestBody DirectoryDto directoryDto,
                                         @PathVariable("type") String directoryType) {
        return directoryService.add(directoryDto, directoryType);
    }

    @GetMapping("/{type}")
    public List<Directory> getAll(@PathVariable("type") String directoryType, @RequestParam("dicId") Long dicId) {
        return directoryService.getAll(directoryType, dicId);
    }

    @PatchMapping("/{id}")
    public Directory recovery(@PathVariable("id") Long id) {
        return directoryService.recoveryById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Directory> update(@PathVariable("id") Long id, @RequestBody DirectoryDto directoryDto) {
        return directoryService.update(id, directoryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return directoryService.deleteById(id);
    }
}

package open.code.controller;

import open.code.model.Directory;
import open.code.dto.DirectoryDto;
import open.code.service.directory.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public Directory add(@RequestBody DirectoryDto directoryDto,
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Directory update(@PathVariable("id") Long id, @RequestBody DirectoryDto directoryDto) {
        return directoryService.update(id, directoryDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        directoryService.deleteById(id);
    }
}

package open.code.controller;

import open.code.dto.directory_dto.DirectoryFilterDto;
import open.code.model.Directory;
import open.code.dto.directory_dto.DirectoryDto;
import open.code.service.directory.DirectoryService;
import open.code.util.DirectoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/add/{type}")
    @ResponseStatus(HttpStatus.CREATED)
    public Directory add(@RequestBody DirectoryDto directoryDto,
                         @PathVariable("type") String directoryType,
                         @RequestParam Long msgId) {
        return directoryService.add(directoryDto, directoryType);
    }

    @GetMapping("/{type}")
    public Page<Directory> getAll(@PathVariable("type") String directoryType,
                                  @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        return directoryService.getAll(directoryType, page);
    }

    @GetMapping("/deleted/{type}")
    public Page<Directory> getAllDeleted(@PathVariable("type") String directoryType,
                                         @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        return directoryService.getAllDeleted(directoryType, page);
    }

    @GetMapping("/filter/{type}")
    public Page<Directory> getByFilter(@PathVariable("type") String directoryType,
                                       @RequestBody DirectoryFilterDto directoryFilterDto,
                                       @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        return directoryService.getAllByFilter(directoryType, directoryFilterDto, page);
    }

    @GetMapping
    public List<DirectoryType> getAllDirectoryTypes() {
        return directoryService.getDirectoryTypes();
    }

    @PatchMapping("/{id}")
    public Directory recovery(@PathVariable("id") Long id) {
        return directoryService.recoveryById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Directory update(@PathVariable("id") Long id,
                            @RequestBody DirectoryDto directoryDto) {
        return directoryService.update(id, directoryDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        directoryService.deleteById(id);
    }
}

package open.code.controller;

import open.code.model.BankMessage;
import open.code.model.BicDirectoryEntry;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface testInterface {
    // Фильтры
    @GetMapping
    public BicDirectoryEntry findBicByBicId(@RequestParam String bicId);

    @GetMapping
    public List<BicDirectoryEntry> findBicByUserType(@RequestParam String id);

    @GetMapping
    public BicDirectoryEntry findBicByOrgName(@RequestParam String name);

    // Фильтры
    @GetMapping
    public BankMessage findBankMessageByName(@RequestParam String name);

    @GetMapping
    public BankMessage findBankMessageByDateBetween(@RequestParam LocalDate localDate1, @RequestParam LocalDate localDate2);

    // Работа с сущностями
    @PostMapping
    public void addFileToProgram(@RequestPart MultipartFile multipartFile);

    @PostMapping
    public void addFileToProgramWithBankRF(@RequestPart MultipartFile multipartFile);

    @DeleteMapping
    public void deleteFile(@RequestBody BankMessage bankMessage);

    @PutMapping
    public void updateFile(@RequestBody BankMessage bankMessage);
}

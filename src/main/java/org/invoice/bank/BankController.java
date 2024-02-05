package org.invoice.bank;

import lombok.RequiredArgsConstructor;
import org.invoice.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("banks/")
@RequiredArgsConstructor
public class BankController {

    private final BankFacade facade;

    @PostMapping()
    public BankDto save(@RequestBody BankDto bankDto) {
        return facade.save(bankDto);
    }

    @GetMapping()
    public List<BankDto> findByUser() {
        return facade.findByUser();
    }

    @GetMapping("{id}")
    public BankDto findById(@PathVariable("id") UUID id) throws NotFoundException {
        return facade.findById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") UUID id) {
        facade.delete(id);
    }
}

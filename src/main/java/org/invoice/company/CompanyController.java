package org.invoice.company;

import lombok.RequiredArgsConstructor;
import org.invoice.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("company/")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyFacade facade;

    @PostMapping()
    public CompanyDto save(@RequestBody CompanyDto companyDto) {
        return facade.save(companyDto);
    }

    @GetMapping()
    public List<CompanyDto> findByUser() {
        return facade.findByUser();
    }

    @GetMapping("{id}")
    public CompanyDto findById(@PathVariable("id") UUID id) throws NotFoundException {
        return facade.findById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") UUID id) {
        facade.delete(id);
    }
}

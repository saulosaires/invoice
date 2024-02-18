package org.invoice.company;

import lombok.RequiredArgsConstructor;
import org.invoice.exception.NotFoundException;
import org.invoice.security.AppUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("companies/")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyFacade facade;

    @PostMapping()
    public CompanyDto save(@RequestBody CompanyDto companyDto) {
        return facade.save(companyDto);
    }

    @GetMapping()
    public CompanyDto findByUser(Authentication authentication) throws NotFoundException {
        AppUserDetails appUserDetails = (AppUserDetails) authentication.getPrincipal();
        return facade.findByUser(appUserDetails.getUser().getId());
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

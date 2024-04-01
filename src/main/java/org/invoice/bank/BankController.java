package org.invoice.bank;

import lombok.RequiredArgsConstructor;
import org.invoice.exception.NotFoundException;
import org.invoice.security.AppUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("banks/")
@RequiredArgsConstructor
public class BankController {

    private final BankFacade facade;

    @PostMapping()
    public BankDto save(Authentication authentication, @RequestBody BankDto bankDto) throws NotFoundException {
        AppUserDetails appUserDetails = (AppUserDetails) authentication.getPrincipal();
        return facade.save(appUserDetails.getUser().getId(), bankDto);
    }

    @GetMapping()
    public List<BankDto> findByUser(Authentication authentication) throws NotFoundException {
        AppUserDetails appUserDetails = (AppUserDetails) authentication.getPrincipal();
        return facade.findByUser(appUserDetails.getUser().getId());
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

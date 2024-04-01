package org.invoice.contact;


import lombok.RequiredArgsConstructor;
import org.invoice.exception.NotFoundException;
import org.invoice.security.AppUserDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("contacts/")
@RequiredArgsConstructor
public class ContactController {

    private final ContactFacade facade;

    @PostMapping()
    public ContactDto save(Authentication authentication, @RequestBody ContactDto contactDto) throws NotFoundException {
        AppUserDetails appUserDetails = (AppUserDetails) authentication.getPrincipal();

        return facade.save(appUserDetails.getUser().getId(), contactDto);
    }

    @GetMapping()
    public Page<ContactDto> findByUser(Authentication authentication, Pageable pageable) throws NotFoundException {
        AppUserDetails appUserDetails = (AppUserDetails) authentication.getPrincipal();

        return facade.findByUser(appUserDetails.getUser().getId(),pageable);
    }

    @GetMapping("{id}")
    public ContactDto findById(@PathVariable("id") UUID id) throws NotFoundException {
        return facade.findById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") UUID id) {
        facade.delete(id);
    }
}

package org.invoice.contact;


import lombok.RequiredArgsConstructor;
import org.invoice.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("contacts/")
@RequiredArgsConstructor
public class ContactController {

    private final ContactFacade facade;

    @PostMapping()
    public ContactDto save(@RequestBody ContactDto contactDto) {
        return facade.save(contactDto);
    }

    @GetMapping()
    public List<ContactDto> findByUser() {
        return facade.findByUser();
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

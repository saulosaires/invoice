package org.invoice.contact;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.invoice.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactFacade {

    private final ContactService contactService;
    private final ContactMapper mapper;

    public ContactDto save(ContactDto contactDto) {
        log.info("ContactFacade.save dto:{}", contactDto);

        Contact contact = contactService.save(mapper.fromDto(contactDto));

        return mapper.toDto(contact);
    }

    public List<ContactDto> findByUser() {
        return contactService.findByUserId().stream().map(mapper::toDto).toList();
    }

    public ContactDto findById(UUID id) throws NotFoundException {
        return mapper.toDto(contactService.findById(id));
    }

    public void delete(UUID id) {
        contactService.delete(id);
    }
}

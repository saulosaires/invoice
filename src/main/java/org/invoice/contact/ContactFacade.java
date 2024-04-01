package org.invoice.contact;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.invoice.company.Company;
import org.invoice.company.CompanyService;
import org.invoice.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactFacade {

    private final CompanyService companyService;
    private final ContactService contactService;
    private final ContactMapper mapper;

    public ContactDto save(UUID userId, ContactDto contactDto) throws NotFoundException {
        log.info("ContactFacade.save userId:{} dto:{}", userId, contactDto);

        Contact contact = mapper.fromDto(contactDto);
        contact.setCompany(companyService.findByUserId(userId));

        return mapper.toDto(contactService.save(contact));
    }

    public Page<ContactDto> findByUser(UUID userId, Pageable pageable) throws NotFoundException {
        Company company = companyService.findByUserId(userId);

        return contactService.findByCompany(company, pageable).map(mapper::toDto);
    }

    public ContactDto findById(UUID id) throws NotFoundException {
        return mapper.toDto(contactService.findById(id));
    }

    public void delete(UUID id) {
        contactService.delete(id);
    }
}

package org.invoice.contact;

import lombok.RequiredArgsConstructor;
import org.invoice.company.Company;
import org.invoice.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static org.invoice.exception.ErrorType.CONTACT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository repository;


    public Contact save(Contact contact) {
        return repository.save(contact);
    }

    public Contact findById(UUID id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(CONTACT_NOT_FOUND, id));
    }

    public Page<Contact> findByCompany(Company company, Pageable pageable) {
        return repository.findByCompany(company,pageable);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

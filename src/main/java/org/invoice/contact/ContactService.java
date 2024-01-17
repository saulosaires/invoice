package org.invoice.contact;

import lombok.RequiredArgsConstructor;
import org.invoice.exception.NotFoundException;
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

    public List<Contact> findByUserId() {
        return repository.findAll();
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

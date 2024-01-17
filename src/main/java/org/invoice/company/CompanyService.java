package org.invoice.company;

import lombok.RequiredArgsConstructor;
import org.invoice.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static org.invoice.exception.ErrorType.COMPANY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository repository;

    public Company save(Company contact) {
        return repository.save(contact);
    }

    public Company findById(UUID id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(COMPANY_NOT_FOUND, id));
    }

    public List<Company> findByUserId() {
        return repository.findAll();
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

}

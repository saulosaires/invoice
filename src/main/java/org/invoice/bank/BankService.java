package org.invoice.bank;

import lombok.RequiredArgsConstructor;
import org.invoice.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static org.invoice.exception.ErrorType.BANK_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository repository;

    public Bank save(Bank bank) {
        return repository.save(bank);
    }

    public Bank findById(UUID id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(BANK_NOT_FOUND, id));
    }

    public List<Bank> findByUserId() {
        return repository.findAll();
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

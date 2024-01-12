package org.invoice.currency;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.invoice.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyFacade {

    private final CurrencyRepository repository;

    public Currency findById(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Currency %s not exists", id));
    }
    List<Currency> findAll() {
        return repository.findAll();
    }
}

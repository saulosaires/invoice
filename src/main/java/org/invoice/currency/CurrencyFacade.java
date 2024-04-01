package org.invoice.currency;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.invoice.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static org.invoice.exception.ErrorType.CURRENCY_NOT_FOUND;

@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyFacade {

    private final CurrencyRepository repository;

    public Currency findById(UUID id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(CURRENCY_NOT_FOUND, id));
    }
    List<Currency> findAll() {
        return repository.findAllByOrderByName();
    }
}

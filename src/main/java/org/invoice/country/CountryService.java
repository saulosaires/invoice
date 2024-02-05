package org.invoice.country;

import lombok.extern.slf4j.Slf4j;
import org.invoice.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.invoice.exception.ErrorType.COUNTRY_NOT_FOUND;

@Service
@Slf4j
public class CountryService {

    private final CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public Country findById(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(COUNTRY_NOT_FOUND, id));
    }

    List<Country> findAll() {
        return repository.findAllByOrderByName();
    }
}

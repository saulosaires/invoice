package org.invoice.country;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("countries/")
@RequiredArgsConstructor
public class CountryController {

    private final CountryFacade facade;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CountryDto> findAll() {
        return facade.findAll();
    }
}

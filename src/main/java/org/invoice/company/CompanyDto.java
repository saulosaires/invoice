package org.invoice.company;

import org.invoice.bank.BankDto;
import org.invoice.country.CountryDto;

import java.util.Set;
import java.util.UUID;

public record CompanyDto(UUID id,
                         String name,
                         String email,
                         String phone,
                         CountryDto country,
                         String address,
                         String vat,
                         Set<BankDto> banks) {
}

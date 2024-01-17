package org.invoice.company;

import org.invoice.bank.BankDto;
import org.invoice.country.Country;

import java.util.Set;
import java.util.UUID;

public record CompanyDto(UUID id,
                         String name,
                         String email,
                         String phone,
                         Country country,
                         String address,
                         String vat,
                         Set<BankDto> banks) {
}

package org.invoice.contact;

import org.invoice.country.CountryDto;

import java.util.UUID;

public record ContactDto(
        UUID id,
        String name,
        String email,
        String phone,
        String address,
        CountryDto country,
        String contactPerson,
        String vat,
        boolean isClient,
        boolean isSupplier,
        String bankName,
        String accountHolder,
        String accountNumber,
        String swiftBic
) {
}

package org.invoice.country;

import java.util.UUID;

public record CountryDto(
        Long id,
        String iso,
        String name,
        String nicename,
        String iso3,
        Integer numcode,
        Integer phonecode) {


}

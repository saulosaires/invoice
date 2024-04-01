package org.invoice.country;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryDto toDto(Country country);
}

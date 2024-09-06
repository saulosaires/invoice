package org.invoice.contact;

import org.invoice.country.CountryMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = CountryMapper.class)
public interface ContactMapper {

  @Mapping(source = "client", target = "isClient")
  @Mapping(source = "supplier", target = "isSupplier")
  ContactDto toDto(Contact contact);

  @Mapping(target = "client", source = "isClient")
  @Mapping(target = "supplier", source = "isSupplier")
  Contact fromDto(ContactDto contactDto);
}

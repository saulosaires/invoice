package org.invoice.contact;

import org.invoice.bank.BankMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    @Mapping(source = "client" , target = "isClient")
    @Mapping(source = "supplier" , target = "isSupplier")
    ContactDto toDto(Contact contact);

    @Mapping(target = "client" , source = "isClient")
    @Mapping(target = "supplier" , source = "isSupplier")
    Contact fromDto(ContactDto contactDto);
}

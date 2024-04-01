package org.invoice.bank;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankMapper {

    BankDto toDto(Bank country);
    Bank fromDto(BankDto country);
}

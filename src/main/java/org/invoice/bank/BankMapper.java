package org.invoice.bank;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BankMapper {

  BankDto toDto(Bank country);

  Bank fromDto(BankDto country);
}

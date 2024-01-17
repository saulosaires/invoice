package org.invoice.company;

import org.invoice.bank.BankMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = BankMapper.class)
public interface CompanyMapper {

    CompanyDto toDto(Company company);

    Company fromDto(CompanyDto companyDto);
}

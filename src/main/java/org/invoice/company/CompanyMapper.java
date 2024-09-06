package org.invoice.company;

import org.invoice.bank.BankMapper;
import org.invoice.country.CountryMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {BankMapper.class, CountryMapper.class})
public interface CompanyMapper {

  CompanyDto toDto(Company company);

  Company fromDto(CompanyDto companyDto);
}

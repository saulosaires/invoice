package org.invoice.bank;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.invoice.company.Company;
import org.invoice.company.CompanyService;
import org.invoice.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankFacade {

    private final CompanyService companyService;
    private final BankService service;
    private final BankMapper mapper;

    public BankDto save(UUID userId, BankDto bankDto) throws NotFoundException {
        log.info("BankFacade.save user:{} dto:{}", userId, bankDto);
        Bank bank = mapper.fromDto(bankDto);
        bank.setCompany(companyService.findByUserId(userId));

        return mapper.toDto(service.save(bank));
    }

    public List<BankDto> findByUser(UUID userId) throws NotFoundException {
        Company company = companyService.findByUserId(userId);
        return service.findByCompany(company).stream().map(mapper::toDto).toList();
    }

    public BankDto findById(UUID id) throws NotFoundException {
        return mapper.toDto(service.findById(id));
    }

    public void delete(UUID id) {
        service.delete(id);
    }
}

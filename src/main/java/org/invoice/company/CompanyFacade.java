package org.invoice.company;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.invoice.exception.NotFoundException;
import org.invoice.user.User;
import org.invoice.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyFacade {

    private final CompanyService companyService;
    private final CompanyMapper mapper;

    public CompanyDto save(CompanyDto companyDto) {
        log.info("CompanyFacade.save dto:{}", companyDto);

        Company company = companyService.save(mapper.fromDto(companyDto));

        return mapper.toDto(company);
    }

    public CompanyDto findByUser(UUID userId) throws NotFoundException {

        return mapper.toDto(companyService.findByUserId(userId));
    }

    public CompanyDto findById(UUID id) throws NotFoundException {
        return mapper.toDto(companyService.findById(id));
    }

    public void delete(UUID id) {
        companyService.delete(id);
    }
}

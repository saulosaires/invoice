package org.invoice.product;

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
public class ProductFacade {

    private final CompanyService companyService;
    private final ProductService service;
    private final ProductMapper mapper;

    public ProductDto save(UUID userId, ProductDto contactDto) throws NotFoundException {
        log.info("ProductFacade.save user:{} dto:{}", userId, contactDto);

        Product contact = mapper.fromDto(contactDto);
        contact.setCompany(companyService.findByUserId(userId));

        return mapper.toDto(service.save(contact));
    }

    public List<ProductDto> findByUser(UUID userId) throws NotFoundException {

        Company company= companyService.findByUserId(userId);

        return service.findByCompany(company).stream().map(mapper::toDto).toList();
    }

    public ProductDto findById(UUID id) throws NotFoundException {
        return mapper.toDto(service.findById(id));
    }

    public void delete(UUID id) {
        service.delete(id);
    }
}

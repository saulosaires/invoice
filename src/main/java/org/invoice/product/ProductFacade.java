package org.invoice.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.invoice.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductFacade {
    private final ProductService service;
    private final ProductMapper mapper;

    public ProductDto save(ProductDto contactDto) {
        log.info("ProductFacade.save dto:{}", contactDto);

        Product contact = service.save(mapper.fromDto(contactDto));

        return mapper.toDto(contact);
    }

    public List<ProductDto> findByUser() {
        return service.findByUserId().stream().map(mapper::toDto).toList();
    }

    public ProductDto findById(UUID id) throws NotFoundException {
        return mapper.toDto(service.findById(id));
    }

    public void delete(UUID id) {
        service.delete(id);
    }
}

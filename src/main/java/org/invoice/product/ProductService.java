package org.invoice.product;

import lombok.RequiredArgsConstructor;
import org.invoice.company.Company;
import org.invoice.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static org.invoice.exception.ErrorType.PRODUCT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    
    public Product save(Product product) {
        return repository.save(product);
    }

    public Product findById(UUID id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(PRODUCT_NOT_FOUND, id));
    }

    public List<Product> findByCompany(Company company) {
        return repository.findByCompany(company);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

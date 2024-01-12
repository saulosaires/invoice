package org.invoice.product;

import lombok.RequiredArgsConstructor;
import org.invoice.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    
    public Product save(Product product) {
        return repository.save(product);
    }

    public Product findById(UUID id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Product %s not exists", id));
    }

    public List<Product> findByUserId() {
        return repository.findAll();
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

package org.invoice.product;

import lombok.RequiredArgsConstructor;
import org.invoice.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("products/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductFacade facade;

    @PostMapping()
    public ProductDto save(@RequestBody ProductDto contactDto) {
        return facade.save(contactDto);
    }

    @GetMapping()
    public List<ProductDto> findByUser() {
        return facade.findByUser();
    }

    @GetMapping("{id}")
    public ProductDto findById(@PathVariable("id") UUID id) throws NotFoundException {
        return facade.findById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") UUID id) {
        facade.delete(id);
    }
}

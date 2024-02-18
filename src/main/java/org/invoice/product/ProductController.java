package org.invoice.product;

import lombok.RequiredArgsConstructor;
import org.invoice.exception.NotFoundException;
import org.invoice.security.AppUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("products/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductFacade facade;

    @PostMapping()
    public ProductDto save(Authentication authentication, @RequestBody ProductDto contactDto) throws NotFoundException {
        AppUserDetails appUserDetails = (AppUserDetails) authentication.getPrincipal();

        return facade.save(appUserDetails.getUser().getId(),contactDto);
    }

    @GetMapping()
    public List<ProductDto> findByUser(Authentication authentication) throws NotFoundException {
        AppUserDetails appUserDetails = (AppUserDetails) authentication.getPrincipal();

        return facade.findByUser(appUserDetails.getUser().getId());
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

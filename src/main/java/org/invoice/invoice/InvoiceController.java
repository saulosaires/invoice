package org.invoice.invoice;


import lombok.RequiredArgsConstructor;
import org.invoice.exception.NotFoundException;
import org.invoice.security.AppUserDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("invoices/")
@RequiredArgsConstructor
public class InvoiceController {

  private final InvoiceFacade facade;

  @PostMapping()
  public InvoiceDto save(Authentication authentication, @RequestBody InvoiceDto invoiceDto) throws NotFoundException {
    AppUserDetails appUserDetails = (AppUserDetails) authentication.getPrincipal();

    return facade.save(appUserDetails.getUser().getId(), invoiceDto);
  }

  @GetMapping()
  public PagedModel<InvoiceDto> findByUser(Authentication authentication, Pageable pageable) throws NotFoundException {
    AppUserDetails appUserDetails = (AppUserDetails) authentication.getPrincipal();

    return facade.findByUser(appUserDetails.getUser().getId(), pageable);
  }

  @GetMapping("{id}")
  public InvoiceDto findById(@PathVariable("id") UUID id) throws NotFoundException {
    return facade.findById(id);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable("id") UUID id) {
    facade.delete(id);
  }
}

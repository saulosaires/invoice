package org.invoice.invoice;

import lombok.RequiredArgsConstructor;
import org.invoice.company.Company;
import org.invoice.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static org.invoice.exception.ErrorType.INVOICE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class InvoiceService {

  private final InvoiceRepository repository;


  public Invoice save(Invoice invoice) {
    return repository.save(invoice);
  }

  public Invoice findById(UUID id) throws NotFoundException {
    return repository.findById(id).orElseThrow(() -> new NotFoundException(INVOICE_NOT_FOUND, id));
  }

  public Page<Invoice> findByCompany(Company company, Pageable pageable) {
    return repository.findByCompany(company, pageable);
  }

  public void delete(UUID id) {
    repository.deleteById(id);
  }
}

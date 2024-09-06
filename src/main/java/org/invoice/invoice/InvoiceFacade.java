package org.invoice.invoice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.invoice.bank.BankService;
import org.invoice.company.Company;
import org.invoice.company.CompanyService;
import org.invoice.contact.ContactService;
import org.invoice.exception.NotFoundException;
import org.invoice.product.ProductService;
import org.invoice.product.item.ProductItem;
import org.invoice.style.StyleMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceFacade {

  private final InvoiceService invoiceService;
  private final CompanyService companyService;
  private final ContactService contactService;
  private final ProductService productService;
  private final BankService bankService;
  private final InvoiceMapper invoiceMapper;
  private final StyleMapper styleMapper;


  @Transactional
  public InvoiceDto save(UUID userId, InvoiceDto invoiceDto) throws NotFoundException {

    Invoice invoice = invoiceMapper.fromDto(invoiceDto);
    invoice.setCompany(companyService.findByUserId(userId));
    invoice.setContact(contactService.findById(invoiceDto.contact().id()));
    invoice.setBank(bankService.findById(invoiceDto.bank().id()));
    invoice.setStyle(styleMapper.fromDto(invoiceDto.style()));

    invoice.setComment(invoiceDto.comment());

    List<ProductItem> productItem = new ArrayList<>();
    for (var itemDto : invoiceDto.productItem()) {
      ProductItem item = new ProductItem();
      item.setProduct(productService.findById(itemDto.product().id()));
      item.setDescription(itemDto.description());
      item.setQuantity(itemDto.quantity());
      item.setDiscount(itemDto.discount());
      item.setInvoice(invoice);
      productItem.add(item);
    }
    invoice.setProductItem(productItem);
    return invoiceMapper.toDto(invoiceService.save(invoice));
  }

  public PagedModel<InvoiceDto> findByUser(UUID userId, Pageable pageable) throws NotFoundException {

    Company company = companyService.findByUserId(userId);

    return new PagedModel<>(
            invoiceService.findByCompany(company, pageable).map(invoiceMapper::toDto)
    );
  }

  public InvoiceDto findById(UUID id) throws NotFoundException {
    return invoiceMapper.toDto(invoiceService.findById(id));
  }

  public void delete(UUID id) {
    invoiceService.delete(id);
  }
}

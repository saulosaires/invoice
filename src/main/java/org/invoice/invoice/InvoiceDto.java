package org.invoice.invoice;

import org.invoice.bank.BankDto;
import org.invoice.company.CompanyDto;
import org.invoice.contact.ContactDto;
import org.invoice.product.item.ProductItemDto;
import org.invoice.style.StyleDto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record InvoiceDto(

        UUID id,
        CompanyDto company,
        ContactDto contact,
        String invoiceNumber,
        Instant date,
        Instant dueDate,
        String dateFormatted,
        String dueDateFormatted,
        List<ProductItemDto> productItem,
        String status,
        String comment,
        BankDto bank,
        StyleDto style
) {

  public BigDecimal getAmount() {

    BigDecimal amount = BigDecimal.ZERO;

    for (ProductItemDto item : productItem) {
      amount = amount.add(item.getAmount());
    }
    amount = amount.setScale(2, java.math.RoundingMode.HALF_EVEN);
    return amount;
  }

}

package org.invoice.invoice;

import org.invoice.bank.BankMapper;
import org.invoice.product.item.ProductItemMapper;
import org.invoice.style.StyleMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {ProductItemMapper.class, BankMapper.class, StyleMapper.class})
public interface InvoiceMapper {

  @Mapping(target = "dueDateFormatted", source = "dueDate", qualifiedByName = "instantToString")
  @Mapping(target = "dateFormatted", source = "date", qualifiedByName = "instantToString")
  @Mapping(target = "status", source = "status", qualifiedByName = "invoiceStatusToString")
  InvoiceDto toDto(Invoice invoice);

  Invoice fromDto(InvoiceDto dto);

  @Named("instantToString")
  default String instantToString(Instant instant) {

    return DateTimeFormatter.ofPattern("dd/MM/yyyy")
            .withZone(ZoneId.systemDefault()).format(instant);

  }

  @Named("invoiceStatusToString")
  default String invoiceStatusToString(InvoiceStatus invoiceStatus) {
    return invoiceStatus.getLabel();
  }

}

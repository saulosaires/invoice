package org.invoice.product.item;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductItemMapper {

  ProductItemDto toDto(ProductItem item);

  ProductItem fromDto(ProductItemDto dto);
}

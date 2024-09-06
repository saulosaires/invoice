package org.invoice.product;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

  ProductDto toDto(Product product);

  Product fromDto(ProductDto productDto);
}

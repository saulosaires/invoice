package org.invoice.product;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);

    Product fromDto(ProductDto productDto);
}

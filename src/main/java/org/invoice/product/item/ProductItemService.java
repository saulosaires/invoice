package org.invoice.product.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductItemService {

  private final ProductItemRepository repository;

  public ProductItem save(ProductItem productItem) {
    return repository.save(productItem);
  }


}

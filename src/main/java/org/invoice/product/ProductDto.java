package org.invoice.product;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDto(
        UUID id,
        String name,
        BigDecimal quantity,
        BigDecimal price,
        BigDecimal tax,
        String description) {
}

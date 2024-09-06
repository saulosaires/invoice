package org.invoice.style;

import java.util.UUID;


public record StyleDto(
        UUID id,
        String font,
        Integer red,
        Integer green,
        Integer blue
) {
}

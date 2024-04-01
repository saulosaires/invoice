package org.invoice.bank;

import org.invoice.currency.Currency;

import java.math.BigDecimal;
import java.util.UUID;

public record BankDto(
        UUID id,
        String name,
        String accountNumber,
        Currency currency,
        String swiftBic,
        String type,
        BigDecimal balance
) {
}

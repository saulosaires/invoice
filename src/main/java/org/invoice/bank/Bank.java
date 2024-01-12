package org.invoice.bank;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.invoice.company.Company;
import org.invoice.currency.Currency;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    private Currency currency;
    private String swiftBic;
    private String type;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}

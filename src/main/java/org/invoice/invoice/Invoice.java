package org.invoice.invoice;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.invoice.bank.Bank;
import org.invoice.contact.Contact;
import org.invoice.company.Company;
import org.invoice.product.item.ProductItem;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    private String invoiceNumber;

    private Instant date;

    private Instant dueDate;

    @OneToMany(mappedBy = "invoice")
    @ToString.Exclude
    private List<ProductItem> productItem;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private Bank bank;
}

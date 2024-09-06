package org.invoice.invoice;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.invoice.bank.Bank;
import org.invoice.company.Company;
import org.invoice.contact.Contact;
import org.invoice.product.item.ProductItem;
import org.invoice.style.Style;

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

  @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
  @ToString.Exclude
  private List<ProductItem> productItem;

  private String comment;

  @Enumerated(EnumType.ORDINAL)
  private InvoiceStatus status;

  @ManyToOne
  @JoinColumn(name = "bank_id", referencedColumnName = "id")
  private Bank bank;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "style_id", referencedColumnName = "id")
  private Style style;

}

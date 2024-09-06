package org.invoice.product.item;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.invoice.invoice.Invoice;
import org.invoice.product.Product;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class ProductItem {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
  private Product product;

  private String description;

  @Column(nullable = false)
  private BigDecimal quantity;

  private BigDecimal discount;

  @ManyToOne
  @JoinColumn(name = "invoice_id", nullable = false)
  @ToString.Exclude
  private Invoice invoice;

}

package org.invoice.style;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.invoice.invoice.Invoice;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Style {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String font;
  private Integer red;
  private Integer green;
  private Integer blue;

  @OneToOne(mappedBy = "style")
  private Invoice invoice;

}

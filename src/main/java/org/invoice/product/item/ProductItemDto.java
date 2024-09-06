package org.invoice.product.item;

import org.invoice.product.ProductDto;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.UUID;


public record ProductItemDto(

        UUID id,
        ProductDto product,
        String description,
        BigDecimal quantity,
        BigDecimal discount) {


  public BigDecimal getAmount() {

    BigDecimal amount = BigDecimal.ZERO;

/*
    if (this.invoiceItem.quantity > 0) {
      this.invoiceItem.total = (this.invoiceItem.product.price * this.invoiceItem.quantity);
      this.invoiceItem.discountAmount = this.invoiceItem.total * (this.invoiceItem.discount / 100);
      this.invoiceItem.vat = (this.invoiceItem.total - this.invoiceItem.discountAmount) * (this.invoiceItem.product.tax / 100);

      this.invoiceItem.amountDue = (this.invoiceItem.total + this.invoiceItem.vat - this.invoiceItem.discountAmount);
    }
    */

    if (this.quantity.compareTo(BigDecimal.ZERO) > 0) {
      MathContext mc = new MathContext(2);
      BigDecimal total = this.quantity.multiply(product.price());
      BigDecimal discountAmount = total.multiply(discount.divide(BigDecimal.valueOf(100), mc));
      BigDecimal vat = total.subtract(discountAmount).multiply(product.tax().divide(BigDecimal.valueOf(100), mc));
      amount = total.add(vat).subtract(discountAmount);
    }
    amount = amount.setScale(2, java.math.RoundingMode.HALF_EVEN);
    return amount;
  }

}

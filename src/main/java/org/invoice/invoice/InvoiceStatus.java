package org.invoice.invoice;

import lombok.Getter;

@Getter
public enum InvoiceStatus {

  PAID("Paid"),
  UNPAID("Unpaid"),
  SENT("Sent"),
  NOT_SENT("Not Sent");

  public final String label;

  private InvoiceStatus(String label) {
    this.label = label;
  }

}

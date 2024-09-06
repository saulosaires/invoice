package org.invoice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {
  COMPANY_NOT_FOUND("/company/not-found", HttpStatus.NOT_FOUND, "Company %s was not found"),
  CONTACT_NOT_FOUND("/contact/not-found", HttpStatus.NOT_FOUND, "Contact %s was not found"),
  COUNTRY_NOT_FOUND("/country/not-found", HttpStatus.NOT_FOUND, "Country %s was not found"),
  PRODUCT_NOT_FOUND("/product/not-found", HttpStatus.NOT_FOUND, "Product %s was not found"),
  STYLE_NOT_FOUND("/style/not-found", HttpStatus.NOT_FOUND, "Style %s was not found"),
  BANK_NOT_FOUND("/bank/not-found", HttpStatus.NOT_FOUND, "Bank %s was not found"),
  CURRENCY_NOT_FOUND("/currency/not-found", HttpStatus.NOT_FOUND, "Currency %s was not found"),
  USER_NOT_FOUND("/user/email-not-found", HttpStatus.NOT_FOUND, "User %s was not found"),
  INVOICE_NOT_FOUND("/invoice/not-found", HttpStatus.NOT_FOUND, "Invoice %s was not found"),

  USER_ALREADY_EXIST("/user/already-exist", HttpStatus.BAD_GATEWAY, "User %s already exists"),
  USER_COMPANY_NOT_FOUND("user/company/not-found", HttpStatus.NOT_FOUND, "User %s doesnt belong to any company"),
  USER_INVALID_PASSWORD("/user/invalid-password", HttpStatus.BAD_REQUEST, "User %s invalid password");


  private final String type;
  private final HttpStatus httpStatus;
  private final String message;

  ErrorType(String type, HttpStatus httpStatus, String message) {
    this.type = type;
    this.httpStatus = httpStatus;
    this.message = message;
  }

  public String with(Object... args) {
    return String.format(message, args);
  }
}
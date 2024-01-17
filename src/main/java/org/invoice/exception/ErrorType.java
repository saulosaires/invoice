package org.invoice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {
    COMPANY_NOT_FOUND("/company/not-found", HttpStatus.NOT_FOUND, "Company %s was not found"),
    CONTACT_NOT_FOUND("/contact/not-found", HttpStatus.NOT_FOUND, "Contact %s was not found"),
    COUNTRY_NOT_FOUND("/country/not-found", HttpStatus.NOT_FOUND, "Country %s was not found"),
    PRODUCT_NOT_FOUND("/product/not-found", HttpStatus.NOT_FOUND, "Product %s was not found"),
    CURRENCY_NOT_FOUND("/currency/not-found", HttpStatus.NOT_FOUND, "Currency %s was not found");

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
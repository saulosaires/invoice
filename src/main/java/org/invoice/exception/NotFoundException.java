package org.invoice.exception;

public class NotFoundException extends Exception {

    public NotFoundException(String message, Object obj) {
        super(String.format(message, obj));
    }
}

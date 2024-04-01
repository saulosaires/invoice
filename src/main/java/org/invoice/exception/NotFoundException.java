package org.invoice.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends Exception {

    private final ErrorType errorType;

    public NotFoundException(ErrorType errorType, Object... args) {
        super(errorType.with(args));
        this.errorType = errorType;
    }
}

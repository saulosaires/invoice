package org.invoice.user.exception;

import lombok.Getter;
import org.invoice.exception.ErrorType;

import static org.invoice.exception.ErrorType.USER_INVALID_PASSWORD;

@Getter
public class UserInvalidException extends Exception {

    private final ErrorType errorType;

    public UserInvalidException(Object... args) {
        super(USER_INVALID_PASSWORD.with(args));
        this.errorType = USER_INVALID_PASSWORD;
    }
}

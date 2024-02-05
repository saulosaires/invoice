package org.invoice.user.exception;

import lombok.Getter;
import org.invoice.exception.ErrorType;

import static org.invoice.exception.ErrorType.USER_ALREADY_EXIST;

@Getter
public class UserAlreadyExistException extends Exception {

    private final ErrorType errorType;

    public UserAlreadyExistException(Object... args) {
        super(USER_ALREADY_EXIST.with(args));
        this.errorType = USER_ALREADY_EXIST;
    }
}

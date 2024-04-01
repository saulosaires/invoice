package org.invoice.exception;

import lombok.extern.slf4j.Slf4j;
import org.invoice.user.exception.UserAlreadyExistException;
import org.invoice.user.exception.UserInvalidException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class InvoiceExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {NotFoundException.class})
    protected ProblemDetail notFound(NotFoundException ex, WebRequest request) {
        log.error(ex.getMessage());

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(ex.getErrorType().getHttpStatus(), ex.getMessage());
        problemDetail.setTitle(ex.getErrorType().getType());
        problemDetail.setDetail(ex.getMessage());
        return problemDetail;
    }

    @ExceptionHandler(value = {UserInvalidException.class})
    protected ProblemDetail userInvalid(UserInvalidException ex, WebRequest request) {
        log.error(ex.getMessage());

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(ex.getErrorType().getHttpStatus(), ex.getMessage());
        problemDetail.setTitle(ex.getErrorType().getType());
        problemDetail.setDetail(ex.getMessage());
        return problemDetail;
    }

    @ExceptionHandler(value = {UserAlreadyExistException.class})
    protected ProblemDetail userAlreadyExist(UserAlreadyExistException ex, WebRequest request) {
        log.error(ex.getMessage());

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(ex.getErrorType().getHttpStatus(), ex.getMessage());
        problemDetail.setTitle(ex.getErrorType().getType());
        problemDetail.setDetail(ex.getMessage());
        return problemDetail;
    }


}
package org.invoice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class InvoiceExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {NotFoundException.class})
    protected ProblemDetail userNotFound(NotFoundException ex, WebRequest request) {
        log.error(ex.getMessage());

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle(ex.getErrorType().getType());
        problemDetail.setDetail(ex.getMessage());
        return problemDetail;
    }


}
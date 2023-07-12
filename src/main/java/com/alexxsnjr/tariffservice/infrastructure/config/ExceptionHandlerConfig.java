package com.alexxsnjr.tariffservice.infrastructure.config;

import com.alexxsnjr.tariffservice.domain.NotAvailableTariff;
import com.alexxsnjr.tariffservice.infrastructure.rest.ErrorResponse;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotAvailableTariff.class)
    public ResponseEntity<Object> handleNotAvailableTariff(NotAvailableTariff ex) {
        return createErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentTypeMismatchException ex) {
        return createErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
        MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return createErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private static ResponseEntity<Object> createErrorResponse(String message,
        HttpStatus httpStatus) {

        var errorResponse = ErrorResponse.builder()
            .errors(List.of(httpStatus.getReasonPhrase(), message))
            .build();

        return new ResponseEntity<>(errorResponse, httpStatus);
    }

}
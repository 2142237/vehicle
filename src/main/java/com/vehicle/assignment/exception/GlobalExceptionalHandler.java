package com.vehicle.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(DriverNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleDriverNotFoundException(DriverNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                ErrorCode.DRIVER_NOT_FOUND,
                ErrorCode.DRIVER_NOT_FOUND.getCode()
                //HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(GeneralizedException.class)
    public ResponseEntity<ErrorDetails> handleGeneralizedException(GeneralizedException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                ex.getErrorCode(),
                ex.getErrorCode().getCode()
                //ErrorCode.DUPLICATE_LICENSE_NUMBER,
                //ErrorCode.DUPLICATE_LICENSE_NUMBER.getCode()
                //HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        //
    }

   /* @ExceptionHandler(GeneralizedException.class)
    public final ResponseEntity<ErrorDetails> handleGeneralizedException(GeneralizedException ex) throws Exception {

        ErrorDetails errorDetails = new ErrorDetails(ex.getTimestamp(),
                ex.getErrorCode().getReasonPhrase(), ex.getErrorCode(), ex.getErrorCode().getValue());

        return new ResponseEntity<ErrorDetails>(errorDetails, ex.getHttpStatus());

    }*/




}
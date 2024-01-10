package com.vehicle.assignment.exception;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
public class GeneralizedException extends RuntimeException {
    public GeneralizedException(String message){
        super(message);
    }
    private ErrorCode errorCode;
    private LocalDateTime timestamp;
    private HttpStatus httpStatus;

    public GeneralizedException(String message, ErrorCode errorCode, HttpStatus httpStatus) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.timestamp = LocalDateTime.now();
    }

}

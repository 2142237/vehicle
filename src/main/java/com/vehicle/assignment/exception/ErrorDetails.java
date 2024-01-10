package com.vehicle.assignment.exception;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String description;
    private ErrorCode errorMessage;
    private Integer errorCode;

}


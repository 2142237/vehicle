package com.vehicle.assignment.exception;

public enum ErrorCode {
 DRIVER_NOT_FOUND(1001, "Driver not found"),
    DUPLICATE_LICENSE_NUMBER(1002,"LICENSE NUMBER ALREADY EXIST");

   //NO_DRIVERS_FOUND("404", "no drivers found");

    private final int code;
    private final String description;

    ErrorCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}

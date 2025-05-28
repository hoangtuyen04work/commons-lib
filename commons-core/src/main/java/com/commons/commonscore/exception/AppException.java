package com.commons.commonscore.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends Exception {
    private final ErrorCode errorCode;
    public AppException() {
        super();
        this.errorCode = null; // Hoặc ErrorCode.GENERIC_ERROR
    }
    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}

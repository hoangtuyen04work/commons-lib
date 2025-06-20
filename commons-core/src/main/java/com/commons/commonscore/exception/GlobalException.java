package com.commons.commonscore.exception;

import com.commons.commonscore.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.ParseException;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = ParseException.class)
    ResponseEntity<ApiResponse> handleParseException(final ParseException  e){
        ErrorCode errorCode = ErrorCode.NOT_AUTHENTICATION;
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(ApiResponse.builder()
                        .status(errorCode.getStatus())
                        .message(errorCode.getMessage())
                        .build());
    }
    @ExceptionHandler(value = RuntimeException .class)
    ResponseEntity<ApiResponse> handleRuntimeException(final RuntimeException  e){
        ErrorCode errorCode = ErrorCode.NOT_AUTHENTICATION;
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(ApiResponse.builder()
                        .status(errorCode.getStatus())
                        .message(errorCode.getMessage())
                        .build());
    }
    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<Object> exception(AppException e) {
        ErrorCode errorCode = e.getErrorCode();
        ApiResponse<Object> apiResponse = ApiResponse.builder()
                .message(errorCode.getMessage())
                .status(errorCode.getStatus())
                .build();
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(apiResponse);
    }
}

package com.educate.skinsnake.exception;

import org.springframework.http.HttpStatus;

public class SkinSnakeException extends RuntimeException {

    private final String message;
    private final HttpStatus httpStatus;

    public SkinSnakeException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

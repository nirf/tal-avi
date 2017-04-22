package com.talavi.controller.error.exception;

/**
 * Created by home on 4/20/17.
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException() {
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }
}

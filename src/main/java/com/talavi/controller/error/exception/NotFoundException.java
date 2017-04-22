package com.talavi.controller.error.exception;

/**
 * Created by home on 4/20/17.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}

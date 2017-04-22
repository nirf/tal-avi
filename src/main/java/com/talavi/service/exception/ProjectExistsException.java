package com.talavi.service.exception;

/**
 * Created by home on 4/22/17.
 */
public class ProjectExistsException extends RuntimeException {
    public ProjectExistsException() {
    }

    public ProjectExistsException(String message) {
        super(message);
    }

    public ProjectExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectExistsException(Throwable cause) {
        super(cause);
    }
}

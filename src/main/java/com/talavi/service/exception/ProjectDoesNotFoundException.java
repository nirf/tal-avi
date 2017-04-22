package com.talavi.service.exception;

/**
 * Created by home on 4/22/17.
 */
public class ProjectDoesNotFoundException extends RuntimeException {
    public ProjectDoesNotFoundException() {
    }

    public ProjectDoesNotFoundException(String message) {
        super(message);
    }

    public ProjectDoesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectDoesNotFoundException(Throwable cause) {
        super(cause);
    }
}

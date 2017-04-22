package com.talavi.controller.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by home on 4/22/17.
 */
public class ErrorMessage {
    private String message;
    private String details;
    private List<FieldErrorVM> fieldErrors;

    private ErrorMessage() {
    }

    public ErrorMessage(String message, String details) {
        this.message = message;
        this.details = details;
    }

    public List<FieldErrorVM> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorVM> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void add(String objectName, String field, String message) {
        if (fieldErrors == null) {
            fieldErrors = new ArrayList<>();
        }
        fieldErrors.add(new FieldErrorVM(objectName, field, message));
    }
}

package com.talavi.controller.error.advice;

import com.talavi.controller.error.exception.ConflictException;
import com.talavi.controller.error.exception.NotFoundException;
import com.talavi.controller.vm.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

/**
 * Created by home on 4/4/17.
 */
@RestControllerAdvice
public class AdviceExceptionHandler extends ResponseEntityExceptionHandler {
    //custom exceptions
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> notFoundErrorMessage(NotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), "Something went wrong, please try again");
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    //custom exceptions
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorMessage> conflictErrorMessage(ConflictException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), "Something went wrong, please try again");
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    //Build in exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> generalErrorMessage(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), "Something went wrong, please try again");
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Build in exceptions
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorMessage> accessDeniedErrorMessage(AccessDeniedException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), "Something went wrong, please try again");
        return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "Something went wrong, please try again");
        for (FieldError fieldError : fieldErrors) {
            errorMessage.add(fieldError.getObjectName(), fieldError.getField(), fieldError.getCode());
        }
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorMessage> processValidationError(MethodArgumentNotValidException ex) {
//        BindingResult result = ex.getBindingResult();
//        List<FieldError> fieldErrors = result.getFieldErrors();
//        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "Something went wrong, please try again");
//        for (FieldError fieldError : fieldErrors) {
//            errorMessage.add(fieldError.getObjectName(), fieldError.getField(), fieldError.getCode());
//        }
//        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
//    }
}

package io.github.eshop.domain.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(InvalidCategoryException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCategoryException(InvalidCategoryException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(100, "CATEGORY_NAME_MUST_NOT_BE_NULL", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(101, "CATEGORY_NAME_INVALID", "Category name is invalid");
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handDataIntegrityViolationException(DataIntegrityViolationException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(102, "THE_CATEGORY_MUST_BE_UNIQUE", "This category already exists");
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handCategoryNotFoundException(CategoryNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(103, "THE_CATEGORY_NOT_FOUND", "This category not found");
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(InvalidProductException.class)
    public ResponseEntity<ErrorResponse> handInvalidProductException(InvalidProductException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(104, "PRODUCT_NAME_MUST_NOT_BE_NULL", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(InvalidProductNameException.class)
    public ResponseEntity<ErrorResponse> handInvalidProductNameException(InvalidProductNameException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(105, "PRODUCT_NAME_VALID", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<ErrorResponse> handInvalidUserException(InvalidUserException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(106, "USER_NAME_VALID", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handUserNotFoundException(UserNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(107, "USER_NOT_FOUND", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }

}

package io.github.eshop.domain.exception;

public class InvalidProductNameException extends RuntimeException{
    public InvalidProductNameException(String message) {
        super(message);
    }
}

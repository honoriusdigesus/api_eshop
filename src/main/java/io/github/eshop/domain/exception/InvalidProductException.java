package io.github.eshop.domain.exception;

public class InvalidProductException extends RuntimeException{
    public InvalidProductException(String message) {
        super(message);
    }
}

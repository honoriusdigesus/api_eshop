package io.github.eshop.domain.exception;

public class HttpMessageNotReadableException extends RuntimeException{
    public HttpMessageNotReadableException(String message) {
        super(message);
    }
}

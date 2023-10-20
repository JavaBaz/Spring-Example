package com.github.javabaz.springexample.exception;

public class ClientOfferNotAvailableException extends RuntimeException {
    public ClientOfferNotAvailableException(String message) {
        super(message);
    }
}

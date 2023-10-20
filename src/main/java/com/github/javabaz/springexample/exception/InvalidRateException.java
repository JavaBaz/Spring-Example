package com.github.javabaz.springexample.exception;

public class InvalidRateException extends RuntimeException{
    public InvalidRateException(String message) {
        super(message);
    }
}

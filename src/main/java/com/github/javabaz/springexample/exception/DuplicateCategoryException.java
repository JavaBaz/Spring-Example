package com.github.javabaz.springexample.exception;

public class DuplicateCategoryException extends Exception{
    public DuplicateCategoryException(String message) {
        super(message);
    }
}

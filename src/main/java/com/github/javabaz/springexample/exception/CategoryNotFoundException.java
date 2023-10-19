package com.github.javabaz.springexample.exception;

public class CategoryNotFoundException extends  Exception{
    public CategoryNotFoundException(String message) {
        super(message);
    }
}

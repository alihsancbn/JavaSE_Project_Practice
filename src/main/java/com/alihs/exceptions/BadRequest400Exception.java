package com.alihs.exceptions;

// Bad request: 400
public class BadRequest400Exception extends RuntimeException{
    public BadRequest400Exception(String message) {
        super(message);
    }
}

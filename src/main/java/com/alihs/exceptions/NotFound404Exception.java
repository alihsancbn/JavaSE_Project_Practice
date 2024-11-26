package com.alihs.exceptions;

// Not found: 404
public class NotFound404Exception extends RuntimeException{
    public NotFound404Exception(String message) {
        super(message);
    }
}

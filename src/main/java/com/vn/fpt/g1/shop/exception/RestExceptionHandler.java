package com.vn.fpt.g1.shop.exception;

public class RestExceptionHandler extends RuntimeException  {
    public RestExceptionHandler(String message) {
        super(message);
    }

    public RestExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }
}

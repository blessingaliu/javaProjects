package com.sg.flooringmastery.service;


public class NoOrderExistsException extends Exception {

    public NoOrderExistsException(String message) {
        super(message);
    }

    public NoOrderExistsException(String message, Throwable cause) {
        super(message, cause);
    }

}

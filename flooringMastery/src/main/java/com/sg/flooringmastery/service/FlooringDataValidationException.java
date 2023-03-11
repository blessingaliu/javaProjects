package com.sg.flooringmastery.service;

public class FlooringDataValidationException extends Exception {

    public FlooringDataValidationException(String message) {
        super(message);
    }

    public static class FlooringPersistenceException extends Exception {

        public FlooringPersistenceException(String message) {
            super(message);
        }
    }
}

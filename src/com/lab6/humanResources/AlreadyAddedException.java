package com.lab6.humanResources;

public class AlreadyAddedException extends Exception {
    public AlreadyAddedException() {
    }

    public AlreadyAddedException(String message) {
        super(message);
    }

    public AlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.lab6.humanResources;

public class IllegalDatesException extends Exception {
    IllegalDatesException(){
        super();
    }
    IllegalDatesException(String message){
        super(message);
    }
    public IllegalDatesException(String message, Throwable cause) {
        super(message, cause);
    }
}

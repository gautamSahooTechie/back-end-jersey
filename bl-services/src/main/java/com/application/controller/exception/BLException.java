package com.application.controller.exception;

public class BLException extends Exception {
    public BLException(){
        super();
    }

    public BLException(String message) {
        super(message);
    }

    public BLException(String message, Throwable t) {
        super(message, t);
    }

}

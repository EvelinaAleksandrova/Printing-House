package com.company;

public class PaperNotEnoughException extends Exception {
    public PaperNotEnoughException(String message) {
        super(message);
    }
}

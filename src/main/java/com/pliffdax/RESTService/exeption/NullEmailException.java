package com.pliffdax.RESTService.exeption;

public class NullEmailException extends RuntimeException {
    public NullEmailException(String message) {
        super(message);
    }
}

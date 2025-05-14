package com.pliffdax.RESTService.exeption;

public class NullUsernameException extends RuntimeException {
    public NullUsernameException(String message) {
        super(message);
    }
}

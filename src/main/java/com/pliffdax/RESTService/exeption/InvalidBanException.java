package com.pliffdax.RESTService.exeption;

public class InvalidBanException extends RuntimeException {
    public InvalidBanException(String message) {
        super(message);
    }
}

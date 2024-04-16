package org.example.newalertmessaging.exception.auth.JWT;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(String message) {
        super(message);
    }
}

package kr.co.cofile.hdcdmybatis.exception;

public class BoardRegistrationException extends Exception {
    public BoardRegistrationException(String message) {
        super(message);
    }

    public BoardRegistrationException(String message, Throwable cause) {
        super(message, cause);
    }
}

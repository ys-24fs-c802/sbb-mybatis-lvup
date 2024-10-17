package kr.co.cofile.hdcdmybatis.exception;

public class MemberRegistrationException extends RuntimeException {
    public MemberRegistrationException(String message) {
        super(message);
    }

    public MemberRegistrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
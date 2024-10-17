package kr.co.cofile.hdcdmybatis.exception;

public class MemberDataAccessException extends RuntimeException {
    public MemberDataAccessException(String message) {
        super(message);
    }

    public MemberDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}

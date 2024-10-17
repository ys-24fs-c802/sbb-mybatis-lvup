package kr.co.cofile.hdcdmybatis.exception;

public class MemberDeletionException extends RuntimeException {
    public MemberDeletionException(String message) {
        super(message);
    }

    public MemberDeletionException(String message, Throwable cause) {
        super(message, cause);
    }
}
package kr.co.cofile.hdcdmybatis.exception;

public class BoardNotFoundException extends RuntimeException {

    public BoardNotFoundException(String message) {
        super(message);
    }

    public BoardNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoardNotFoundException(Long boardId) {
        super("Board not found with id: " + boardId);
    }
}
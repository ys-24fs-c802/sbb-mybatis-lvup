package kr.co.cofile.hdcdmybatis.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class DataValidationException extends RuntimeException {
    private final List<String> errors;

    public DataValidationException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }

}
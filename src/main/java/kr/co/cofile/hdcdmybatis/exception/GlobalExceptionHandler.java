package kr.co.cofile.hdcdmybatis.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            DataValidationException.class,
            MemberNotFoundException.class,
            MemberDeletionException.class,
            MemberRegistrationException.class,
            MemberDataAccessException.class
    })
    public ResponseEntity<ErrorResponse> handleCustomExceptions(Exception ex) {
        // dve 패턴 변수
        if (ex instanceof DataValidationException dve) {
            return createErrorResponse(HttpStatus.BAD_REQUEST, dve.getMessage(), dve, dve.getErrors());
        } else if (ex instanceof MemberNotFoundException) {
            return createErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), ex, null);
        } else {
            return createErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), ex, null);
        }
    }

//    // 데이터 유효성 검사 예외처리
//    @ExceptionHandler(DataValidationException.class)
//    public ResponseEntity<ErrorResponse> handleDataValidationException(DataValidationException ex) {
//        return createErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), ex.getErrors(), ex);
//    }
//
//    // 데이터 유효성 검사 예외처리
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//
//        ErrorResponse errorResponse = new ErrorResponse("Validation failed", errors.toString());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//
//    // 회원정보 수정시 예외처리
//    @ExceptionHandler(MemberNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleMemberNotFoundException(MemberNotFoundException ex) {
//        return createErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
//    }
//
//    // 회원 삭제시 예외처리
//    @ExceptionHandler(MemberDeletionException.class)
//    public ResponseEntity<ErrorResponse> handleMemberDeletionException(MemberDeletionException ex) {
//        return createErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
//    }
//
//    // 회원 등록 예외처리
//    @ExceptionHandler(MemberRegistrationException.class)
//    public ResponseEntity<ErrorResponse> handleMemberRegistrationException(MemberRegistrationException ex) {
//        return createErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
//        return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred", ex);
//    }

    // ErrorResponse를 빌더패턴으로 변경
    private ResponseEntity<ErrorResponse> createErrorResponse(HttpStatus status, String error, Exception ex, List<String> details) {
        log.error(error, ex);

        ErrorResponse errorResponse = ErrorResponse.builder()
                .error(error)
                .message(ex.getMessage())
                .details(details)
                .build();

        return ResponseEntity.status(status).body(errorResponse);
    }

//    private ResponseEntity<ErrorResponse> createErrorResponse(HttpStatus status, String error, Exception ex) {
//        log.error(error, ex);
//        ErrorResponse errorResponse = new ErrorResponse(error, ex.getMessage());
//        return ResponseEntity.status(status).body(errorResponse);
//    }
//    private ResponseEntity<ErrorResponse> createErrorResponse(HttpStatus status, String error, List<String> detail, Exception ex) {
//        log.error(error, ex);
//        ErrorResponse errorResponse = new ErrorResponse(error, ex.getMessage(), detail);
//        return ResponseEntity.status(status).body(errorResponse);
//    }
}
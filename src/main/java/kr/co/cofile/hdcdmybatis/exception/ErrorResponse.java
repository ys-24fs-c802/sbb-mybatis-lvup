package kr.co.cofile.hdcdmybatis.exception;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

//@Getter
//@Setter
//@RequiredArgsConstructor
//@AllArgsConstructor
//public class ErrorResponse {
//    @NonNull
//    private String error;
//    @NonNull
//    private String message;
//    private List<String> details;
//}

@Getter
@Builder
public class ErrorResponse {
    private final String error;
    private final String message;
    private final List<String> details;

    public ErrorResponse(String error, String message, List<String> details) {
        this.error = error;
        this.message = message;
        this.details = details;
    }
}
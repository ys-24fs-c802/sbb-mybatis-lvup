package kr.co.cofile.hdcdmybatis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
public class Member {

    // 입력값 검증 규칙
    // 문자열이 null이 아니고 trim한 길이가 0보다 크다를 검사
    @NotBlank
    private String userId = "hongkd";

    private String password = "1234";

    // 여러개의 입력값 검증 규칙
    @NotBlank
    // trim한 길이가 3보다 크다를 검사
    @Size(max = 3)
    private String userName;

    // 이메일 주소를 검사
    @Email
    private String email;
    private String gender;

    // 중첩된 자바빈즈의 입력값을 검증
    @Valid
    private Address address;

    // 자바빈즈 컬렉션의 입력값을 검증
    @Valid
    private List<Card> cardList;

    // 과거 날짜인지를 검사 | 미래 날짜는 @Future
    @Past
    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate dateOfBirth;

}

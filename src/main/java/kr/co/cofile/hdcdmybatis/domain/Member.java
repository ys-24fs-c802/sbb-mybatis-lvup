package kr.co.cofile.hdcdmybatis.domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {

    // 입력값 검증 규칙
    @NotBlank
    private String userId = "hongkd";

    private String password = "1234";

    // 여러개의 입력값 검증 규칙
    @NotBlank
    @Size(max = 3)
    private String userName;

    private String email;
    private String gender;

    private Address address;

    private List<Card> cardList;

    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate dateOfBirth;

}

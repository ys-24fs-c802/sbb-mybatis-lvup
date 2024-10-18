package kr.co.cofile.hdcdmybatis.domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {

	@NotBlank
    private String userId = "hongkd";

    private String password = "1234";
    
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

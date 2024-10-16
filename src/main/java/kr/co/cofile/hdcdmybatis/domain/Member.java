package kr.co.cofile.hdcdmybatis.domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {

    private String userId = "hongkd";

    private String password = "1234";

    private Address address;

    private List<Card> cardList;

    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate dateOfBirth;

}

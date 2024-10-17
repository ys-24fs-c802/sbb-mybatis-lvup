package kr.co.cofile.hdcdmybatis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.YearMonth;

@Getter
@Setter
@ToString
public class Card {

    @NotBlank
    private String no;

    // 미래 날찌인지를 검사
    @JsonFormat(pattern = "yyyyMM")
    @Future
    private YearMonth validMonth;

}
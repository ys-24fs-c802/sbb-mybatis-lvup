package kr.co.cofile.hdcdmybatis.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {

    @NotBlank
    private String postCode;

    @NotBlank
    private String location;

}
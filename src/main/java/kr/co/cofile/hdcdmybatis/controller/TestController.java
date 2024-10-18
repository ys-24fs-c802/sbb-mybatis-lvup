package kr.co.cofile.hdcdmybatis.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.co.cofile.hdcdmybatis.domain.Address;
import kr.co.cofile.hdcdmybatis.domain.Card;
import kr.co.cofile.hdcdmybatis.domain.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping(path = "", produces="text/plain;charset=utf-8")
    public ResponseEntity<String> register(@Validated @RequestBody Member member, BindingResult result) {
        log.info("register");
        if(result.hasErrors()) {
            return new ResponseEntity<>(result.toString(), HttpStatus.BAD_REQUEST);
        }

        log.info("member.getUserName() = " + member.getUserName());

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

}
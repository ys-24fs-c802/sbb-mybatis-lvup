package kr.co.cofile.hdcdmybatis.controller;

import java.time.LocalDate;
import java.util.List;

import kr.co.cofile.hdcdmybatis.domain.Address;
import kr.co.cofile.hdcdmybatis.domain.Card;
import kr.co.cofile.hdcdmybatis.domain.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/members")
public class MemberController {

    @PostMapping("/register01")
    public ResponseEntity<String> register01(@RequestBody Member member) {
        log.info("register01");

        log.info("userId = " + member.getUserId());
        log.info("password = " + member.getPassword());

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

        return entity;
    }

    @PostMapping("/register01/{userId}")
    public ResponseEntity<String> register0101(@PathVariable("userId") String userId, @RequestBody Member member) {
        log.info("register0101");

        log.info("userId = " + userId);

        log.info("member.getUserId() = " + member.getUserId());
        log.info("member.getPassword() = " + member.getPassword());

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

        return entity;
    }

    @PostMapping("/register02")
    public ResponseEntity<String> register02(@RequestBody List<Member> memberList) {
        log.info("register02");

        for (Member member : memberList) {
            log.info("userId = " + member.getUserId());
            log.info("password = " + member.getPassword());
        }

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

        return entity;
    }

    @PostMapping("/register03")
    public ResponseEntity<String> register03(@RequestBody Member member) {
        log.info("register03");

        log.info("userId = " + member.getUserId());
        log.info("password = " + member.getPassword());

        Address address = member.getAddress();

        if (address != null) {
            log.info("address.getPostCode() = " + address.getPostCode());
            log.info("address.getLocation() = " + address.getLocation());
        } else {
            log.info("address == null");
        }

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

        return entity;
    }

    @PostMapping("/register04")
    public ResponseEntity<String> register04(@RequestBody Member member) {
        log.info("register04");

        log.info("userId = " + member.getUserId());
        log.info("password = " + member.getPassword());

        List<Card> cardList = member.getCardList();

        if (cardList != null) {
            log.info("cardList.size() = " + cardList.size());

            for (Card card : cardList) {
                log.info("card.getNo() = " + card.getNo());
                log.info("card.getValidMonth() = " + card.getValidMonth());
            }
        } else {
            log.info("cardList == null");
        }

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

        return entity;
    }

    @GetMapping("/registerForm")
    public String registerForm() {
        log.info("registerForm");

        return "registerForm";
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Member member) {
        log.info("register");

        log.info("userId = " + member.getUserId());
        log.info("password = " + member.getPassword());

        log.info("member.getDateOfBirth() = " + member.getDateOfBirth());

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<Member> read() {
        log.info("register");

        Member member = new Member();
        member.setUserId("hongkd");
        member.setPassword("1234");

        LocalDate dateOfBirth = LocalDate.of(2024, 9, 8);
        member.setDateOfBirth(dateOfBirth);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping(path = "/upload", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> upload(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();

        log.info("originalName: " + originalFilename);

        ResponseEntity<String> entity = new ResponseEntity<>("UPLOAD SUCCESS " + originalFilename, HttpStatus.OK);

        return entity;
    }

    @PostMapping(path = "", produces="text/plain;charset=utf-8")
    public ResponseEntity<String> register(@Validated @RequestBody Member member, BindingResult result) {
        log.info("register");

        if(result.hasErrors()) {
            return new ResponseEntity<>(result.toString(), HttpStatus.BAD_REQUEST);
        }

        log.info("member.getUserId() = " + member.getUserId());
        log.info("member.getPassword() = " + member.getPassword());
        log.info("member.getUserName() = " + member.getUserName());
        log.info("member.getEmail() = " + member.getEmail());
        log.info("member.getGender() = " + member.getGender());

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
}
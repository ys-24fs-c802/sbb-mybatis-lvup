package kr.co.cofile.hdcdmybatis.controller;

import kr.co.cofile.hdcdmybatis.domain.Address;
import kr.co.cofile.hdcdmybatis.domain.Card;
import kr.co.cofile.hdcdmybatis.domain.Member;
import kr.co.cofile.hdcdmybatis.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/members")
public class MemberController {

    MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/register01")
    public ResponseEntity<String> register01(@RequestBody Member member) {
        log.info("register01");

        log.info("userId = " + member.getUserId());
        log.info("password = " + member.getPassword());

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    @PostMapping("/register01/{userId}")
    public ResponseEntity<String> register0101(@PathVariable("userId") String userId, @RequestBody Member member) {
        log.info("register0101");

        log.info("userId = " + userId);

        log.info("member.getUserId() = " + member.getUserId());
        log.info("member.getPassword() = " + member.getPassword());

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    @PostMapping("/register02")
    public ResponseEntity<String> register02(@RequestBody List<Member> memberList) {
        log.info("register02");

        for (Member member : memberList) {
            log.info("userId = " + member.getUserId());
            log.info("password = " + member.getPassword());
        }

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
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

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
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

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
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

        return new ResponseEntity<>("UPLOAD SUCCESS " + originalFilename, HttpStatus.OK);
    }

    @PostMapping(path = "", produces="text/plain;charset=utf-8")
    public ResponseEntity<String> register(@Validated @RequestBody Member member, BindingResult result) {
        log.info("register");

        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            List<ObjectError> globalErrors = result.getGlobalErrors();
            List<FieldError> fieldErrors = result.getFieldErrors();

            log.info("allErrors.size() = " + allErrors.size());
            log.info("globalErrors.size() = " + globalErrors.size());
            log.info("fieldErrors.size() = " + fieldErrors.size());

            for (ObjectError objectError : allErrors) {
                log.info("allError = " + objectError);
            }

            for (ObjectError objectError : globalErrors) {
                log.info("globalError = " + objectError);
            }

            for (FieldError fieldError : fieldErrors) {
                log.info("fieldError = " + fieldError);
                log.info("fieldError.getDefaultMessage() = " + fieldError.getDefaultMessage());
            }

            return new ResponseEntity<>(result.toString(), HttpStatus.BAD_REQUEST);
        }

        log.info("member.getUserId() = " + member.getUserId());
        log.info("member.getPassword() = " + member.getPassword());
        log.info("member.getUserName() = " + member.getUserName());
        log.info("member.getEmail() = " + member.getEmail());
        log.info("member.getGender() = " + member.getGender());

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Member member) {
        log.info("delete");

        memberService.delete(member.getUserId());

        return ResponseEntity.ok().build();
    }
}
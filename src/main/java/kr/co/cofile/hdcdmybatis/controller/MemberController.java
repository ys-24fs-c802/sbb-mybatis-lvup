package kr.co.cofile.hdcdmybatis.controller;

import java.util.List;

import kr.co.cofile.hdcdmybatis.domain.Address;
import kr.co.cofile.hdcdmybatis.domain.Card;
import kr.co.cofile.hdcdmybatis.domain.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

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

}
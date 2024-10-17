package kr.co.cofile.hdcdmybatis.service;

import kr.co.cofile.hdcdmybatis.domain.Member;

import java.util.List;

public interface MemberService {
    Member read(String userId);
    List<Member> readAll();
    Member register(Member member);
    Member update(Member member);
    int delete(String userId);
}
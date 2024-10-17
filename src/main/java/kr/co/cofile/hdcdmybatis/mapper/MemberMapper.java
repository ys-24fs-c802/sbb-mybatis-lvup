package kr.co.cofile.hdcdmybatis.mapper;

import kr.co.cofile.hdcdmybatis.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    Optional<Member> getMemberById(String userId);
    List<Member> getAllMembers();
    Member insertMember(Member member);
    Member updateMember(Member member);
    int deleteMember(String userId); // 삭제된 레코드의 수
}
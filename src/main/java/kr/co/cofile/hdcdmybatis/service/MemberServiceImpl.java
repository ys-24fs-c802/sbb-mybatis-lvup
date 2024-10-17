package kr.co.cofile.hdcdmybatis.service;

import kr.co.cofile.hdcdmybatis.domain.Member;
import kr.co.cofile.hdcdmybatis.exception.*;
import kr.co.cofile.hdcdmybatis.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final Validator validator;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper, Validator validator) {
        this.memberMapper = memberMapper;
        this.validator = validator;
    }

    @Override
    public Member read(String userId) {
        try {
            return memberMapper.getMemberById(userId)
                    .orElseThrow(() -> new MemberNotFoundException("Member not found with id: " + userId));
        } catch (DataAccessException ex) {
            throw new MemberDataAccessException("Database error occurred while fetching all members", ex);
        }
    }

    @Override
    public List<Member> readAll() {
        try {
            return memberMapper.getAllMembers();
        } catch (DataAccessException ex) {
            throw new MemberDataAccessException("Database error occurred while fetching all members", ex);
        }
    }

    @Override
    public Member register(Member member) {
        validateMember(member);
        try {
            return memberMapper.insertMember(member);
        } catch (DuplicateKeyException ex) {
            throw new MemberRegistrationException("Failed to register member due to duplication", ex);
        } catch (DataIntegrityViolationException ex) {
            throw new MemberRegistrationException("Failed to register board due to data integrity violation", ex);
        } catch (Exception ex) {
            throw new MemberRegistrationException("Unexpected error occurred while registering member", ex);
        }
    }

    @Override
    public Member update(Member member) throws MemberNotFoundException, MemberRegistrationException {
        // 수정 데이터 유효성 검사
        validateMember(member);

        try {
            return memberMapper.updateMember(member);
        } catch (DataIntegrityViolationException e) {
            throw new MemberRegistrationException("Update violates data integrity constraints", e);
        } catch (OptimisticLockingFailureException e) {
            throw new MemberRegistrationException("Member was updated by another transaction", e);
        } catch (DataAccessException e) {
            throw new MemberRegistrationException("Database error occurred while updating member", e);
        }
    }

    @Override
    public int delete(String userId) {
        try {
            return memberMapper.deleteMember(userId);
        } catch (DataIntegrityViolationException ex) {
            throw new MemberDeletionException("Cannot delete member due to existing references", ex);
        } catch (DataAccessException ex) {
            // 관리자에게 문의하세요.
            throw new MemberDeletionException("Database error occurred while deleting member", ex);
        }
    }

    private void validateMember(Member member) {
        // BeanPropertyBindingResult는 Errors 인터페이스의 구현체 중에 하나
        // BeanPropertyBindingResult(유효성 검사 대상 객체, 유효성 검사 대상 객체의 이름)
        Errors errors = new BeanPropertyBindingResult(member, "member");
        validator.validate(member, errors);
        if (errors.hasErrors()) {
            // 자바 스트림
            List<String> errorMessages = errors.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            throw new DataValidationException("Data validation failed", errorMessages);
        }
    }
}
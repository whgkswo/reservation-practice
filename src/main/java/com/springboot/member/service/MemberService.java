package com.springboot.member.service;


import com.springboot.exeption.BusinessLoginException;
import com.springboot.exeption.ExceptionCode;
import com.springboot.member.dto.MemberDto;
import com.springboot.member.entity.Member;
import com.springboot.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    public Member findMember(long memberId){
        return findVerifiedMember(memberId);
    }
    private Member findVerifiedMember(long memberId){
        Optional<Member> optionalMember = memberRepository.findByMemberId(memberId);
        return optionalMember.orElseThrow(() ->
            new BusinessLoginException(ExceptionCode.MEMBER_NOT_FOUND));
    }
}


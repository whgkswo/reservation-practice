package com.springboot.member.service;


import com.springboot.auth.utils.CustomAuthorityUtils;
import com.springboot.exception.BusinessLogicException;
import com.springboot.exception.ExceptionCode;
import com.springboot.member.entity.Member;
import com.springboot.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {
    private MemberRepository memberRepository;
    private PasswordEncoder passwordEncoder;
    private CustomAuthorityUtils customAuthorityUtils;

    public Member createMember(Member member){
        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);

        List<String> roles = customAuthorityUtils.createRoles("hgd@gmail.com");
        member.setRoles(roles);
        Member savedMember = memberRepository.save(member);
        return savedMember;
    };
    public Member findMember(long memberId){
        return findVerifiedMember(memberId);
    }
    private Member findVerifiedMember(long memberId){
        Optional<Member> optionalMember = memberRepository.findByMemberId(memberId);
        return optionalMember.orElseThrow(() ->
            new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }
}


package com.springboot.member.controller;

import com.springboot.member.dto.MemberDto;
import com.springboot.member.entity.Member;
import com.springboot.member.mapper.MemberMapper;
import com.springboot.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {
    private MemberService memberService;
    private MemberMapper memberMapper;

    public MemberController(MemberMapper memberMapper){
        this.memberMapper = memberMapper;
    }
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody MemberDto.Post postDto){
        Member findMember = memberService.findMember(postDto.getMemberId());
        return new ResponseEntity<>(findMember, HttpStatus.CREATED);
    }
}

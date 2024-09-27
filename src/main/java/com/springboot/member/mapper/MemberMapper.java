package com.springboot.member.mapper;

import com.springboot.member.dto.MemberDto;
import com.springboot.member.entity.Member;

public interface MemberMapper {
    Member memberPostDtoToMember(MemberDto.Post postDto);
}

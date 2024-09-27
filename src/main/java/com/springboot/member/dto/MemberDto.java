package com.springboot.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {
    @AllArgsConstructor
    @Getter
    public static class Post{
        private long memberId;
        private String id;
    }
}

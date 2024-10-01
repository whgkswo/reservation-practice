package com.springboot.member.dto;

import com.springboot.gender.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

public class MemberDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Post{
        private String userId;
        private String password;
        private String nickname;
        private LocalDate birth;
        private Gender gender;
        private String ci;
    }
}

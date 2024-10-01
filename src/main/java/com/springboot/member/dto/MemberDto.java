package com.springboot.member.dto;

import com.springboot.gender.Gender;
import com.springboot.reservation.dto.ReservationDto;
import com.springboot.reservation.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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

    public static class Response{
        private long memberId;
        private String userid;
        private String nickname;
        private LocalDate birth;
        private Gender gender;
        private List<ReservationDto.Response> reservations;
    }
}

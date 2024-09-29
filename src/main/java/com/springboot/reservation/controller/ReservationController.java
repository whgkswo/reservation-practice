package com.springboot.reservation.controller;

import com.springboot.exception.BusinessLogicException;
import com.springboot.exception.ExceptionCode;
import com.springboot.member.entity.Member;
import com.springboot.member.service.MemberService;
import com.springboot.reservation.dto.ReservationDto;
import com.springboot.reservation.entity.Reservation;
import com.springboot.reservation.mapper.ReservationMapper;
import com.springboot.reservation.service.ReservationService;
import com.springboot.utils.UriCreator;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {
    private final String DEFAULT_URL = "/reservations";
    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;
    private final MemberService memberService;
    @PostMapping
    public ResponseEntity<Reservation> postReservation(@RequestBody ReservationDto.Post postDto){
        Reservation tempReservation = reservationMapper.reservationPostDtoToReservation(postDto);
        Member counselor = memberService.findMember(postDto.getCounselorId());
        Member client = memberService.findMember(postDto.getClientId());
        tempReservation.setCounselor(counselor);
        tempReservation.setClient(client);

        Reservation reservation = reservationService.createReservation(tempReservation);

        URI location = UriCreator.createUri(DEFAULT_URL, reservation.getReservationId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<Reservation> getReservation(@RequestParam(required = false) String counselorName,
                                                      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime){
        if(counselorName != null){
            Reservation reservation = reservationService.getReservation(counselorName);
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        }
        if(startTime != null){
            Reservation reservation = reservationService.getReservation(startTime);
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        }
        throw new BusinessLogicException(ExceptionCode.PARAM_NOT_FOUND);
    }
}

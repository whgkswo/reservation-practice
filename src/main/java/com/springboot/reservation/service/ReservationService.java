package com.springboot.reservation.service;

import com.springboot.exception.BusinessLogicException;
import com.springboot.exception.ExceptionCode;
import com.springboot.reservation.entity.Reservation;
import com.springboot.reservation.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    public Reservation createReservation(Reservation reservation){
        // 이미 예약된 시간대이면 에러 반환
        Optional<Reservation> optionalReservation = reservationRepository.findByStartTime(reservation.getStartTime());
        optionalReservation.ifPresent(existingReservation -> {
            throw new BusinessLogicException(ExceptionCode.RESERVATION_TIMESLOT_OCCUPIED);
        });

        return reservationRepository.save(reservation);
    }
    public Reservation getReservation(String counselorName){
        Optional<Reservation> optionalReservation = reservationRepository.findByCounselorNickname(counselorName);
        return optionalReservation.orElseThrow(() -> new BusinessLogicException(ExceptionCode.RESERVATION_NOT_FOUND));
    }
    public Reservation getReservation(LocalDateTime startTime){
        Optional<Reservation> optionalReservation = reservationRepository.findByStartTime(startTime);
        return optionalReservation.orElseThrow(() -> new BusinessLogicException(ExceptionCode.RESERVATION_NOT_FOUND));
    }
}

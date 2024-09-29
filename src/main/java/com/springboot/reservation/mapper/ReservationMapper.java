package com.springboot.reservation.mapper;

import com.springboot.reservation.dto.ReservationDto;
import com.springboot.reservation.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper {
    Reservation reservationPostDtoToReservation(ReservationDto.Post postDto);
}

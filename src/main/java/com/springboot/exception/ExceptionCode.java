package com.springboot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ExceptionCode {
    PARAM_NOT_FOUND(400, "At least 1 of valid params required"),
    MEMBER_NOT_FOUND(404, "Member not found"),
    RESERVATION_NOT_FOUND(404, "Reservation not found"),
    RESERVATION_TIMESLOT_OCCUPIED(409, "Already occupied timeslot"),
    ;
    @Getter
    private int status;
    @Getter
    private String message;
}

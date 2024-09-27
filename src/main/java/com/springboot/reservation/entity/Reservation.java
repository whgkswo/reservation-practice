package com.springboot.reservation.entity;

import com.springboot.member.entity.Member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reservation {
    @Id
    private long reservationId;
    @Column
    private Member counselor;

    @Column
    private Member client;

}

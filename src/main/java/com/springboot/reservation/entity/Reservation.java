package com.springboot.reservation.entity;

import com.springboot.member.entity.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservationId;
    @ManyToOne
    @JoinColumn(name = "counselor_id")
    private Member counselor;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Member client;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();
}

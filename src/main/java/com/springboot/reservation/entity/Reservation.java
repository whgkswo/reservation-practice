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

    /*@ManyToOne
    @JoinColumn(name = "counselor_id")
    private Member counselor;*/

    private long counselorId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus = ReservationStatus.PENDING;

    @Column
    private String comment;

    @Column
    private String cancelComment;

    @Column
    @Enumerated(EnumType.STRING)
    private CounselingType type;

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private LocalDateTime modifiedAt = LocalDateTime.now();

    public enum CounselingType {
        CALL,
        CHAT
    }

    public enum ReservationStatus{
        PENDING,
        CANCELLED_BY_CLIENT,
        CANCELLED_BY_COUNSELOR,
        COMPLETED,
        REPORT_COMPLETED
    }
}

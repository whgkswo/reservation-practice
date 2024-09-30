package com.springboot.counselor.entity;

import com.springboot.gender.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Counselor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long counselorId;

    @Column
    private String password;

    @Column
    private String phone;

    @Column
    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private CounselorStatus counselorStatus = CounselorStatus.VERIFICATION_WAITING;

    @Column
    private String ci;

    @Column
    private String name;

    @Column
    private String userId;

    @Column
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @Column
    private String company;

    @Column
    private int chatPrice = 30000;

    @Column
    private int call_price = 50000;

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private LocalDateTime modifiedAt = LocalDateTime.now();

    @AllArgsConstructor
    public enum CounselorStatus{
        VERIFICATION_WAITING,
        ACTIVE,
        INACTIVE
    }
}

package com.springboot.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {
    @Id
    private long memberId;

    @Column
    private String id;

    @Column
    private String password;

    
}

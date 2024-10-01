package com.springboot.counselor.available_date;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class AvailableTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long availableTimeId;

    @ManyToOne
    @JoinColumn(name = "available_date_id")
    private AvailableDate availableDate;

    @Column
    private LocalTime startTime;

    @Column
    private LocalTime endTime;

    @Column
    private boolean isReserved = false;

    public AvailableTime(LocalTime startTime, LocalTime endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setAvailableDate(AvailableDate availableDate){
        this.availableDate = availableDate;
        if(!availableDate.getAvailableTimes().contains(this)){
            availableDate.addAvailableTime(this);
        }
    }
}

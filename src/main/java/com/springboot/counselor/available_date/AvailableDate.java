package com.springboot.counselor.available_date;

import com.springboot.counselor.entity.Counselor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AvailableDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long availableDateId;

    @ManyToOne
    @JoinColumn(name = "counselor_id")
    private Counselor counselor;

    @Column
    private LocalDate date;

    @OneToMany(mappedBy = "availableDate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvailableTime> availableTimes = new ArrayList<>();

    public AvailableDate(LocalDate date){
        this.date = date;
        // 9 ~ 24시까지 예약가능시간 자동 생성
        for(int i = 9; i< 24; i++){
            addAvailableTime(new AvailableTime(LocalTime.of(i,0), LocalTime.of(i,50)));
        }
    }

    public void setCounselor(Counselor counselor){
        this.counselor = counselor;
        if(!counselor.getAvailableDates().contains(this)){
            counselor.getAvailableDates().add(this);
        }
    }
    public void addAvailableTime(AvailableTime availableTime){
        availableTimes.add(availableTime);
        if(availableTime.getAvailableDate() == null){
            availableTime.setAvailableDate(this);
        }
    }
}

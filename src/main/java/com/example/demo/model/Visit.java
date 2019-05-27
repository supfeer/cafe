package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Embeddable
public class Visit {

    private int cafeId;
    private int traffic;
    private Date date;

    public Visit(int cafeId, int traffic, Date date) {
        this.cafeId = cafeId;
        this.traffic = traffic;
        this.date = date;
    }

    public Visit() {
    }
}

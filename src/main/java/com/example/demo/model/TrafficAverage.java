package com.example.demo.model;

import lombok.Data;

@Data
public class TrafficAverage {
    private String cafeName;
    private float trafficAvgDay;

    public TrafficAverage(String cafeName, float trafficAvgDay) {
        this.cafeName = cafeName;
        this.trafficAvgDay = trafficAvgDay;
    }
}

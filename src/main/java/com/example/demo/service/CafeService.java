package com.example.demo.service;

import com.example.demo.model.TrafficAverage;
import com.example.demo.repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeService {
    private final CafeRepository cafeRepository;

    @Autowired
    public CafeService(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    @Query("select c.name,  avg (v.traffic) as trafficAvgDay from Cafe c left join Visit v on v.cafeId = c.id group by c.id")
    public List<TrafficAverage> getTrafficAvg(){
        return cafeRepository.getTrafficAvg();
    }
}

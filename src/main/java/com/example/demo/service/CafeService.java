package com.example.demo.service;

import com.example.demo.model.TrafficAverage;
import com.example.demo.repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeService {
    private final CafeRepository cafeRepository;

    @Autowired
    public CafeService(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    public List<TrafficAverage> getTrafficAvg(){
        return cafeRepository.getTrafficAvg();
    }
}

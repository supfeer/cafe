package com.example.demo.controller;

import com.example.demo.model.Cafe;
import com.example.demo.model.TrafficAverage;
import com.example.demo.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/getTrafficAvg")
public class CafeController {
    private final CafeService cafeService;

    @Autowired
    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @GetMapping
    public ResponseEntity<List<TrafficAverage>> getTrafficAvg() {
        return ResponseEntity.ok(cafeService.getTrafficAvg());
    }
}

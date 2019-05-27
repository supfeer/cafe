package com.example.demo.repository;

import com.example.demo.model.Cafe;
import com.example.demo.model.TrafficAverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Integer> {

    @Query("select c.name, (select avg (v.traffic) from Visit v where v.cafeId = c.id) as trafficAvgDay from Cafe c")
    List<TrafficAverage> getTrafficAvg();
}

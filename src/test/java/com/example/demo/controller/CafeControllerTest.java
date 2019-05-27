package com.example.demo.controller;

import com.example.demo.model.Cafe;
import com.example.demo.model.TrafficAverage;
import com.example.demo.repository.CafeRepository;
import com.example.demo.service.CafeService;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.mockito.Mockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;

@WebFluxTest
@RunWith(SpringRunner.class)
public class CafeControllerTest {
    @Autowired
    WebTestClient client;
    @MockBean
    CafeService cafeService;

    @Test
    public void shouldReturnAVG() {
        Mockito.when(cafeService.getTrafficAvg()).thenReturn(
                Arrays.asList(new TrafficAverage("first", 3.0f),new TrafficAverage("second", 4.0f))
        );
        client.get()
                .uri("/getTrafficAvg")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody()
                .jsonPath("$.[0].cafeName").value(equalTo("first"))
                .jsonPath("$.[0].trafficAvgDay").value(equalTo(3.0))
                .jsonPath("$.[1].cafeName").value(equalTo("second"))
                .jsonPath("$.[1].trafficAvgDay").value(equalTo(4.0));
    }
}
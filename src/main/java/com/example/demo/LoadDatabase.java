package com.example.demo;

import com.example.demo.model.Cafe;
import com.example.demo.model.Visit;
import com.example.demo.repository.CafeRepository;
import com.example.demo.repository.VisitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(CafeRepository repository, VisitRepository visitRepository) {
        return args -> {
            log.info("Preloading " + repository.saveAndFlush(new Cafe(1, "burglar")));
            log.info("Preloading " + repository.saveAndFlush(new Cafe(2, "thief")));
            log.info("Preloading " + visitRepository.saveAndFlush(new Visit(1, 1, Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))));
            log.info("Preloading " + visitRepository.saveAndFlush(new Visit(1, 2, Date.from(Instant.now().plus(2, ChronoUnit.DAYS)))));
            log.info("Preloading " + visitRepository.saveAndFlush(new Visit(1, 3, Date.from(Instant.now().plus(3, ChronoUnit.DAYS)))));

            log.info("Preloading " + visitRepository.saveAndFlush(new Visit(2, 5, Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))));
            log.info("Preloading " + visitRepository.saveAndFlush(new Visit(2, 10, Date.from(Instant.now().plus(2, ChronoUnit.DAYS)))));
            log.info("Preloading " + visitRepository.saveAndFlush(new Visit(2, 20, Date.from(Instant.now().plus(3, ChronoUnit.DAYS)))));
        };
    }
}
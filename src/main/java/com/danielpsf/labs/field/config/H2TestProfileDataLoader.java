package com.danielpsf.labs.field.config;

import com.danielpsf.labs.field.statistic.metric.domain.Metric;
import com.danielpsf.labs.field.statistic.metric.repository.MetricRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Component
@Profile("test")
public class H2TestProfileDataLoader implements ApplicationRunner {

    private MetricRepository metricRepository;

    public H2TestProfileDataLoader(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        // Data that should compose the report
        metricRepository.save(
                Metric.builder()
                        .vegetation(0.9)
                        .occurrenceAt(Date.from(Instant.now().minus(Duration.ofDays(28))))
                        .build()
        );
        metricRepository.save(
                Metric.builder()
                        .vegetation(0.8)
                        .occurrenceAt(Date.from(Instant.now().minus(Duration.ofDays(29))))
                        .build()
        );

        // Data that shouldn't enter the report
        metricRepository.save(
                Metric.builder()
                        .vegetation(0.1)
                        .occurrenceAt(Date.from(Instant.now().minus(Duration.ofDays(30))))
                        .build()
        );
    }
}

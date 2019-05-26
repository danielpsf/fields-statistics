package com.danielpsf.labs.field.statistic.metric.domain;

import org.springframework.stereotype.Component;

@Component
public class MetricFactory {

    public Metric create(MetricRequest metricRequest) {
        return Metric.builder()
                .occurrenceAt(metricRequest.getOccurrenceAt())
                .vegetation(metricRequest.getVegetation())
                .build();
    }
}

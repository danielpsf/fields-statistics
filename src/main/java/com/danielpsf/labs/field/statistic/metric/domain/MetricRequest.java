package com.danielpsf.labs.field.statistic.metric.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class MetricRequest {

    private Double vegetation;
    private Date occurrenceAt;

    public MetricRequest() {
    }
}

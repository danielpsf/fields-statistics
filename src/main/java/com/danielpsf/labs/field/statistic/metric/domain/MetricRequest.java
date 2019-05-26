package com.danielpsf.labs.field.statistic.metric.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class MetricRequest {

    private Double vegetation;
    private Date occurrenceAt;
}

package com.danielpsf.labs.field.statistic.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StatisticData {

    private Float min;
    private Float max;
    private Double avg;
}

package com.danielpsf.labs.field.statistic.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StatisticData {

    private Double min;
    private Double max;
    private Double avg;
}

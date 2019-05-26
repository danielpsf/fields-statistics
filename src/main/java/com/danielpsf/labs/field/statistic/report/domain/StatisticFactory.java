package com.danielpsf.labs.field.statistic.report.domain;

import org.springframework.stereotype.Component;

@Component
public class StatisticFactory {

    public StatisticResponse createResponse(StatisticData statisticData) {
        return StatisticResponse.builder()
                .vegetationResponse(
                        VegetationResponse.builder()
                                .min(statisticData.getMin())
                                .max(statisticData.getMax())
                                .avg(statisticData.getAvg())
                                .build()
                )
                .build();
    }
}

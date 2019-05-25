package com.danielpsf.labs.field.statistic.domain.factory;

import com.danielpsf.labs.field.statistic.domain.Statistic;
import com.danielpsf.labs.field.statistic.domain.request.StatisticRequest;
import com.danielpsf.labs.field.statistic.domain.response.StatisticData;
import com.danielpsf.labs.field.statistic.domain.response.StatisticResponse;
import com.danielpsf.labs.field.statistic.domain.response.VegetationResponse;
import org.springframework.stereotype.Component;

@Component
public class StatisticFactory {

    public Statistic create(StatisticRequest statisticRequest) {
        return Statistic.builder()
                .occurrenceAt(statisticRequest.getOccurrenceAt())
                .vegetation(statisticRequest.getVegetation())
                .build();
}

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

package com.danielpsf.labs.field.statistic.domain.factory;

import com.danielpsf.labs.field.statistic.domain.Statistic;
import com.danielpsf.labs.field.statistic.domain.request.StatisticRequest;
import com.danielpsf.labs.field.statistic.domain.response.StatisticData;
import com.danielpsf.labs.field.statistic.domain.response.StatisticResponse;
import com.danielpsf.labs.field.statistic.domain.response.VegetationResponse;
import org.springframework.stereotype.Component;

@Component
public class StatisticFactory {

    public StatisticRequest createRequest(Statistic statistic) {
        return new StatisticRequest.Builder()
                .withOccurrenceAt(statistic.getOccurrenceAt())
                .withVegetation(statistic.getVegetation())
                .build();
    }

    public Statistic create(StatisticRequest statisticRequest) {
        return new Statistic.Builder()
                .withVegetation(statisticRequest.getVegetation())
                .withOccurrenceAt(statisticRequest.getOccurrenceAt())
                .build();
    }

    public StatisticResponse createResponse(StatisticData statisticData) {
        return new StatisticResponse.Builder()
                .withVegatationResponse(
                        new VegetationResponse.Builder()
                                .withMin(statisticData.getMin())
                                .withMax(statisticData.getMax())
                                .withAvg(statisticData.getAvg())
                                .build()
                )
                .build();
    }
}

package com.danielpsf.labs.field.statistic.service;

import com.danielpsf.labs.field.statistic.domain.factory.StatisticFactory;
import com.danielpsf.labs.field.statistic.domain.request.StatisticRequest;
import com.danielpsf.labs.field.statistic.domain.response.StatisticResponse;
import com.danielpsf.labs.field.statistic.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class StatisticService {

    public static final int PAST_30_DAYS = 30;
    private StatisticRepository repository;
    private StatisticFactory factory;

    public StatisticService(StatisticRepository repository, StatisticFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    public void persistStatistic(StatisticRequest statisticRequest) {
        repository.save(factory.create(statisticRequest));
    }

    public StatisticResponse fetchStatistic() {
        return factory.createResponse(
                repository.fetchStatistics(getCurrentDateMinus(PAST_30_DAYS), getCurrentDate())
        );
    }

    private Date getCurrentDateMinus(int days) {
        return Date.valueOf(LocalDate.now().minusDays(days));
    }

    private Date getCurrentDate() {
        return Date.valueOf(LocalDate.now());
    }
}

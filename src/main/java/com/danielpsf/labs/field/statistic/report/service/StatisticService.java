package com.danielpsf.labs.field.statistic.report.service;

import com.danielpsf.labs.field.statistic.report.domain.StatisticFactory;
import com.danielpsf.labs.field.statistic.report.domain.StatisticResponse;
import com.danielpsf.labs.field.statistic.report.repository.StatisticRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class StatisticService {

    private static final int PAST_30_DAYS = 30;
    private StatisticRepository repository;
    private StatisticFactory factory;

    public StatisticService(StatisticRepository repository, StatisticFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    public StatisticResponse fetchStatistic() {
        return factory.createResponse(
                repository.fetchStatistics(getCurrentDateMinus(PAST_30_DAYS), getCurrentDate())
        );
    }

    private Date getCurrentDateMinus(int days) {
        return Date.from(
                LocalDate.now()
                        .minusDays(days)
                        .atStartOfDay(ZoneId.systemDefault())
                        .toInstant()
        );
    }

    private Date getCurrentDate() {
        return Date.from(
                LocalDate.now()
                        .atStartOfDay(ZoneId.systemDefault())
                        .toInstant()
        );
    }
}

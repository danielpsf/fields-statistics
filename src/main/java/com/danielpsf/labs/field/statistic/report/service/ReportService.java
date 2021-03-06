package com.danielpsf.labs.field.statistic.report.service;

import com.danielpsf.labs.field.statistic.report.domain.StatisticFactory;
import com.danielpsf.labs.field.statistic.report.domain.StatisticResponse;
import com.danielpsf.labs.field.statistic.report.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Service
public class ReportService {

    private static final int PAST_30_DAYS = 30;
    private ReportRepository repository;
    private StatisticFactory statisticFactory;

    public ReportService(ReportRepository repository, StatisticFactory statisticFactory) {
        this.repository = repository;
        this.statisticFactory = statisticFactory;
    }

    public StatisticResponse generateStatisticReport() {
        return statisticFactory.createResponse(
                repository.fetchStatisticsReport(getCurrentDateMinus(PAST_30_DAYS), getCurrentDate())
        );
    }

    private Date getCurrentDateMinus(int days) {
        return Date.from(
                Instant.now().minus(Duration.ofDays(days))
        );
    }

    private Date getCurrentDate() {
        return Date.from(
                Instant.now()
        );
    }
}

package com.danielpsf.labs.field.statistic.report.repository;

import com.danielpsf.labs.field.statistic.metric.domain.Metric;
import com.danielpsf.labs.field.statistic.report.domain.StatisticData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface ReportRepository extends Repository<Metric, Long> {

    @Query(value = "SELECT " +
            "NEW com.danielpsf.labs.field.statistic.report.domain.StatisticData(" +
                "MIN(s.vegetation)," +
                "MAX(s.vegetation)," +
                "AVG(s.vegetation)" +
            ") " +
            "FROM Metric s " +
            "WHERE occurrenceAt BETWEEN :startDate AND :endDate")
    public StatisticData fetchStatisticsReport(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}

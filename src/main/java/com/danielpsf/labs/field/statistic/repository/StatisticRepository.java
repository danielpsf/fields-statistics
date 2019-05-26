package com.danielpsf.labs.field.statistic.repository;

import com.danielpsf.labs.field.statistic.domain.Statistic;
import com.danielpsf.labs.field.statistic.domain.response.StatisticData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface StatisticRepository extends JpaRepository<Statistic, Long> {

    @Query(value = "SELECT " +
            "NEW com.danielpsf.labs.field.statistic.domain.response.StatisticData(" +
                "MIN(s.vegetation)," +
                "MAX(s.vegetation)," +
                "AVG(s.vegetation)" +
            ") " +
            "FROM Statistic s " +
            "WHERE occurrenceAt BETWEEN :startDate AND :endDate")
    public StatisticData fetchStatistics(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
}

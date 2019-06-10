package com.danielpsf.labs.field.statistic.report.service

import com.danielpsf.labs.field.statistic.report.domain.StatisticData
import com.danielpsf.labs.field.statistic.report.domain.StatisticFactory
import com.danielpsf.labs.field.statistic.report.repository.ReportRepository
import spock.lang.Shared
import spock.lang.Specification

class ReportServiceSpec extends Specification {
    @Shared
    StatisticFactory statisticFactory

    @Shared
    ReportRepository repository

    void setup() {
        statisticFactory = Mock(StatisticFactory)
        repository = Mock(ReportRepository)
    }

    def "should interact with ReportRepository and StatisticFactory to generate a statistics report"() {
        given:
        ReportService service = new ReportService(repository, statisticFactory)

        when:
        service.generateStatisticReport()

        then:
        1 * repository.fetchStatisticsReport(_, _) >> new StatisticData(1.8, 1.9, 1.85)
        1 * statisticFactory.createResponse({ it.min == 1.8 && it.max == 1.9 && it.avg == 1.85 })
    }
}

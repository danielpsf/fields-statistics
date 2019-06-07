package com.danielpsf.labs.field.statistic.report.controller

import com.danielpsf.labs.field.statistic.report.domain.StatisticResponse
import com.danielpsf.labs.field.statistic.report.domain.VegetationResponse
import com.danielpsf.labs.field.statistic.report.service.ReportService
import spock.lang.Shared
import spock.lang.Specification

class ReportControllerSpec extends Specification {

    @Shared
    ReportService service

    void setup() {
        service = Mock(ReportService)
    }

    def "should interact with ReportService to get the statistics report"() {
        given:
        ReportController controller = new ReportController(service)

        and:
        StatisticResponse statisticResponse = StatisticResponse.builder()
                .vegetationResponse(
                        VegetationResponse.builder()
                                .min(1.8)
                                .max(1.9)
                                .avg(1.85)
                                .build()
                ).build()

        when:
        StatisticResponse response = controller.getStatistic()

        then:
        1 * service.generateStatisticReport() >> statisticResponse

        and:
        response.vegetationResponse.with {
            min == 1.8
            max == 1.9
            avg == 1.85
        }
    }
}

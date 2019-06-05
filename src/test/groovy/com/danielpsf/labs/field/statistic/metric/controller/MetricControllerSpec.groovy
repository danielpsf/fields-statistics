package com.danielpsf.labs.field.statistic.metric.controller


import com.danielpsf.labs.field.statistic.metric.domain.MetricRequest
import com.danielpsf.labs.field.statistic.metric.exception.NotImplementedException
import com.danielpsf.labs.field.statistic.metric.service.MetricService
import spock.lang.Shared
import spock.lang.Specification

import java.time.Instant

class MetricControllerSpec extends Specification {
    @Shared
    MetricService service

    @Shared
    MetricRequest metricEntryFromYesterday = MetricRequest.builder()
            .vegetation(1.5)
            .occurrenceAt(Date.from(Instant.parse("2019-06-05T00:01:00Z")))
            .build()

    void setup() {
        service = Mock(MetricService)
    }

    def "should interact with MetricService to persist the metric data"() {
        given:
        MetricController controller = new MetricController(service)

        when:
        controller.postMetric(metricEntryFromYesterday)

        then:
        1 * service.persistStatistic(metricEntryFromYesterday)
    }

    def "should retrieve NotImplemented exception when trying to use putMetric method"() {
        given:
        MetricController controller = new MetricController(service)

        when:
        controller.putMetric()

        then:
        NotImplementedException e = thrown(NotImplementedException)

        and:
        e.message == "Not supported yet"
    }

}

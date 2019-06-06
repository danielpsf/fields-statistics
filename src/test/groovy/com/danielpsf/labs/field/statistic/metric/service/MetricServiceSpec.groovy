package com.danielpsf.labs.field.statistic.metric.service

import com.danielpsf.labs.field.statistic.metric.domain.Metric
import com.danielpsf.labs.field.statistic.metric.domain.MetricFactory
import com.danielpsf.labs.field.statistic.metric.domain.MetricRequest
import com.danielpsf.labs.field.statistic.metric.repository.MetricRepository
import spock.lang.Shared
import spock.lang.Specification

import java.time.Instant

class MetricServiceSpec extends Specification {
    @Shared
    MetricRepository repository

    @Shared
    MetricFactory factory

    @Shared
    MetricRequest metricRequestEntry = MetricRequest.builder()
            .vegetation(1.5)
            .occurrenceAt(Date.from(Instant.parse("2019-06-05T00:01:00Z")))
            .build()

    @Shared
    Metric metricEntry = Metric.builder()
            .occurrenceAt(Date.from(Instant.parse("2019-06-05T00:01:00Z")))
            .vegetation(1.5)
            .build()

    void setup() {
        repository = Mock(MetricRepository)
        factory = Mock(MetricFactory)
    }

    def "Should interact with MetricRepository to the metric data"() {
        given:
        MetricService service = new MetricService(repository, factory)

        when:
        service.persistStatistic(metricRequestEntry)

        then:
        1 * factory.create(metricRequestEntry) >> metricEntry
        1 * repository.save(metricEntry)
    }
}

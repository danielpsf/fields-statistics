package com.danielpsf.labs.field.statistic.metric.domain

import spock.lang.Specification

import java.time.Instant

class MetricFactorySpec extends Specification {

    def "should create a Metric based upon a MetricRequest"() {
        given:
        MetricFactory factory = new MetricFactory()

        MetricRequest metricRequest = MetricRequest.builder()
                .vegetation(1.5)
                .occurrenceAt(Date.from(Instant.parse("2019-06-05T00:01:00Z")))
                .build()

        when:
        Metric metric = factory.create(metricRequest)

        then:
        metric.occurrenceAt == metricRequest.occurrenceAt
        metric.vegetation == metricRequest.vegetation
    }
}

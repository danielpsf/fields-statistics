package com.danielpsf.labs.field.statistic.report.domain

import spock.lang.Specification

class StatisticFactorySpec extends Specification {

    def "should create a StatisticResponse based upon StatisticData"() {
        given:
        StatisticFactory factory = new StatisticFactory()

        and:
        StatisticData statisticData = new StatisticData(1.8, 1.9, 1.85)

        when:
        StatisticResponse statisticResponse = factory.createResponse(statisticData)

        then:
        statisticResponse.vegetationResponse.with {
            min == statisticData.min
            max == statisticData.max
            avg == statisticData.avg
        }
    }
}

package com.danielpsf.labs.field.statistic.report.controller

import com.danielpsf.labs.IntegrationTestSpecification
import com.danielpsf.labs.field.Application
import com.danielpsf.labs.field.config.H2TestProfileDataLoader
import com.danielpsf.labs.field.config.H2TestProfileJPAConfig
import org.junit.runner.RunWith
import org.spockframework.runtime.SpockRuntime
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest(
        classes = [
                Application.class,
                H2TestProfileJPAConfig.class,
                H2TestProfileDataLoader.class
        ],
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ActiveProfiles("test")
class ReportControllerIntegrationSpec extends IntegrationTestSpecification {

    def setup() {
        configureRestClient("http://localhost:8080", MediaType.APPLICATION_JSON)
    }

    def "GetMetric should return the statistics report based upon known ingested values"() {
        when: "retrieving the statistic report"
        def response = restClient.get(
                path: '/field-statistics',
                contentType: MediaType.APPLICATION_JSON
        )

        then: "the status should be 200"
        response.status == 200

        and: "The body should contains the proper values"
        response.data.vegetationResponse.min == 0.8
        response.data.vegetationResponse.max == 0.9
        response.data.vegetationResponse.avg == 0.8500000000000001
    }
}
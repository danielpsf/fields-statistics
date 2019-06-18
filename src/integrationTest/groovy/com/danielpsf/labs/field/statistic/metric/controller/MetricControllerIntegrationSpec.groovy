package com.danielpsf.labs.field.statistic.metric.controller

import com.danielpsf.labs.IntegrationTestSpecification
import com.danielpsf.labs.field.Application
import com.danielpsf.labs.field.config.H2TestProfileDataLoader
import com.danielpsf.labs.field.config.H2TestProfileJPAConfig
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(
        classes = [
                Application.class,
                H2TestProfileJPAConfig.class,
                H2TestProfileDataLoader.class
        ],
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ActiveProfiles("test")
class MetricControllerIntegrationSpec extends IntegrationTestSpecification {

    def setup() {
        configureRestClient("http://localhost:8080", MediaType.APPLICATION_JSON)
    }

    def "PutMetric should return a not Implemented Error"() {
        when: "updating metrics"
        def response = restClient.put(
                path: '/field-statistics',
                contentType: MediaType.APPLICATION_JSON
        )

        then: "the status should be 501"
        response.status == 501

        and: "The body should contains the proper values"
        response.data.status == 'NOT_IMPLEMENTED'
        response.data.message == 'Not supported yet'
        response.data.error == 'NotImplementedException'
    }

    def "PostMetric should return an empty body and HTTP Status 204"() {
        when: "creating metrics"
        def response = restClient.post(
                path: '/field-statistics',
                contentType: MediaType.APPLICATION_JSON,
                body: ["vegetation": 0.0001, "occurrenceAt": "2019-04-15T00:01:01Z"]
        )

        then: "the status should be 204"
        response.status == 204

        and: "the body must be empty"
        response.data == null
    }
}

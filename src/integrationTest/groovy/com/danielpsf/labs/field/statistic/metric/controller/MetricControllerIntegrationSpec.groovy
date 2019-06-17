package com.danielpsf.labs.field.statistic.metric.controller

import com.danielpsf.labs.IntegrationTestSpecification
import com.danielpsf.labs.field.Application
import com.danielpsf.labs.field.config.H2TestProfileJPAConfig
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

@SpringBootTest(
        classes = [
                Application.class,
                H2TestProfileJPAConfig.class],
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ActiveProfiles("test")
@ContextConfiguration
class MetricControllerIntegrationSpec extends IntegrationTestSpecification {

    def setup() {
        configureRestClient("http://localhost:8080", MediaType.APPLICATION_JSON)
    }

    def "PutMetric should return a not Implemented Error"() {
        when: "get all arrivals"
        def response = restClient.put(
                path: '/field-statistics',
                contentType: MediaType.APPLICATION_JSON
        )

        then: "Status is 501"
        response.status == 501

        and: "Body contains proper values"
        response.data.status == 'NOT_IMPLEMENTED'
        response.data.message == 'Not supported yet'
        response.data.error == 'NotImplementedException'
        println response
    }

    def "PostMetric should return an empty body and HTTP Status 204"() {
        when: "get all arrivals"
        def response = restClient.post(
                path: '/field-statistics',
                contentType: MediaType.APPLICATION_JSON,
                body: ["vegetation": 0.0001, "occurrenceAt": "2019-06-15T00:01:01Z"]
        )

        then: "Status is 501"
        response.status == 204

        and: "Body must be empty"
        response.data == null
    }
}

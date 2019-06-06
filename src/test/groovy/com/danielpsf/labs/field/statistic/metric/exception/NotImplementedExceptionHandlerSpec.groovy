package com.danielpsf.labs.field.statistic.metric.exception


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.mock.web.MockHttpServletRequest
import org.springframework.web.context.request.ServletWebRequest
import spock.lang.Specification

class NotImplementedExceptionHandlerSpec extends Specification {
    def "should handle NotFoundException and return a custom ResponseEntity"() {
        given:
        NotImplementedExceptionHandler handler = new NotImplementedExceptionHandler()

        and:
        NotImplementedException exception = new NotImplementedException("not implemented exception thrown ;)")
        ServletWebRequest servletWebRequest = new ServletWebRequest(new MockHttpServletRequest())

        when:
        ResponseEntity responseEntity = handler.handleNotImplemented(exception, servletWebRequest)

        then:
        responseEntity.statusCode == HttpStatus.NOT_IMPLEMENTED

        and:
        responseEntity.body.with {
            status == HttpStatus.NOT_IMPLEMENTED
            error == NotImplementedException.class.simpleName
            message == "not implemented exception thrown ;)"
        }
    }
}

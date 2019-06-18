package com.danielpsf.labs

import groovyx.net.http.RESTClient
import spock.lang.Specification

class IntegrationTestSpecification extends Specification {

    RESTClient restClient = new RESTClient()

    def configureRestClient(String uri, def contentType) {
        restClient.setUri(uri)
        restClient.setContentType(contentType)

        restClient.handler.failure = { resp, data ->
            resp.setData(data)
            String headers = ""
            resp.headers.each {
                headers = headers + "${it.name} : ${it.value}\n"
            }
            return resp
        }

    }
}

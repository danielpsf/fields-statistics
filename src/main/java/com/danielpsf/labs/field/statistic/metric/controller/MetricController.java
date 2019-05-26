package com.danielpsf.labs.field.statistic.metric.controller;

import com.danielpsf.labs.field.statistic.metric.domain.MetricRequest;
import com.danielpsf.labs.field.statistic.metric.exception.NotImplementedException;
import com.danielpsf.labs.field.statistic.metric.service.MetricService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/field-statistics")
public class MetricController {

    private final MetricService service;

    public MetricController(MetricService service) {
        this.service = service;
    }

    @PutMapping
    public void putMetric() {
        throw new NotImplementedException("Not supported yet");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void postMetric(@RequestBody MetricRequest metricRequest) {
        service.persistStatistic(metricRequest);
    }
}

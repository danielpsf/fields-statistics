package com.danielpsf.labs.field.statistic.metric.service;

import com.danielpsf.labs.field.statistic.metric.domain.MetricFactory;
import com.danielpsf.labs.field.statistic.metric.domain.MetricRequest;
import com.danielpsf.labs.field.statistic.metric.repository.MetricRepository;
import org.springframework.stereotype.Service;

@Service
public class MetricService {

    private MetricRepository repository;
    private MetricFactory factory;

    public MetricService(MetricRepository repository, MetricFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    public void persistStatistic(MetricRequest metricRequest) {
        repository.save(factory.create(metricRequest));
    }
}

package com.danielpsf.labs.field.statistic.metric.repository;

import com.danielpsf.labs.field.statistic.metric.domain.Metric;
import org.springframework.data.repository.CrudRepository;

public interface MetricRepository extends CrudRepository<Metric, Long> {
}

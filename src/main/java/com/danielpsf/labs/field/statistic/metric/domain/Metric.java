package com.danielpsf.labs.field.statistic.metric.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Builder
public class Metric {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date occurrenceAt;
    private Double vegetation;
}

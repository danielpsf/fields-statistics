package com.danielpsf.labs.field.statistic.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@Getter
@Builder
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date occurrenceAt;
    private Double vegetation;
}

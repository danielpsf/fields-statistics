package com.danielpsf.labs.field.statistic.domain.request;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class StatisticRequest {

    private Float vegetation;
    private Date occurrenceAt;
}

package com.danielpsf.labs.field.statistic.domain.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VegetationResponse {

    private Float min;
    private Float max;
    private Double avg;
}

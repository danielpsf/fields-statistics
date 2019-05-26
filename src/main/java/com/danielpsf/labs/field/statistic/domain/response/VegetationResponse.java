package com.danielpsf.labs.field.statistic.domain.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VegetationResponse {

    private Double min;
    private Double max;
    private Double avg;
}

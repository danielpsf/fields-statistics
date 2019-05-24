package com.danielpsf.labs.field.statistic.domain.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class VegetationResponse {

    private Float min;
    private Float max;
    private Double avg;

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public VegetationResponse fromJson(String jsonString) throws IOException {
        return new ObjectMapper().readValue(jsonString, VegetationResponse.class);
    }

    public String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }

    @Override
    public String toString() {
        try {
            return toJson();
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static class Builder {

        private VegetationResponse vegetationResponse = new VegetationResponse();

        public Builder withMin(Float min) {
            this.vegetationResponse.setMin(min);
            return this;
        }

        public Builder withMax(Float max) {
            this.vegetationResponse.setMax(max);
            return this;
        }

        public Builder withAvg(Double avg) {
            this.vegetationResponse.setAvg(avg);
            return this;
        }

        public VegetationResponse build() {
            return this.vegetationResponse;
        }
    }

}

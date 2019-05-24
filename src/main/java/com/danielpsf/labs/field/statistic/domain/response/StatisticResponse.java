package com.danielpsf.labs.field.statistic.domain.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class StatisticResponse {

    private VegetationResponse vegetationResponse;

    public StatisticResponse() {
    }

    public VegetationResponse getVegetationResponse() {
        return vegetationResponse;
    }

    public void setVegetationResponse(VegetationResponse vegetationResponse) {
        this.vegetationResponse = vegetationResponse;
    }

    public StatisticResponse fromJson(String jsonString) throws IOException {
        return new ObjectMapper().readValue(jsonString, StatisticResponse.class);
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

        private StatisticResponse statisticResponse = new StatisticResponse();

        public Builder withVegatationResponse(VegetationResponse vegetationResponse) {
            this.statisticResponse.setVegetationResponse(vegetationResponse);
            return this;
        }

        public StatisticResponse build() {
            return this.statisticResponse;
        }
    }

}

package com.danielpsf.labs.field.statistic.domain.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Date;

public class StatisticRequest {

    private Float vegetation;
    private Date occurrenceAt;

    public StatisticRequest() {
    }

    public Float getVegetation() {
        return vegetation;
    }

    public void setVegetation(Float vegetation) {
        this.vegetation = vegetation;
    }

    public Date getOccurrenceAt() {
        return occurrenceAt;
    }

    public void setOccurrenceAt(Date occurrenceAt) {
        this.occurrenceAt = occurrenceAt;
    }

    public StatisticRequest fromJson(String jsonString) throws IOException {
        return new ObjectMapper().readValue(jsonString, StatisticRequest.class);
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

        private StatisticRequest statisticRequest = new StatisticRequest();

        public Builder withVegetation(Float vegetation) {
            this.statisticRequest.setVegetation(vegetation);
            return this;
        }

        public Builder withOccurrenceAt(Date occurrenceAt) {
            this.statisticRequest.setOccurrenceAt(occurrenceAt);
            return this;
        }

        public StatisticRequest build() {
            return this.statisticRequest;
        }
    }

}

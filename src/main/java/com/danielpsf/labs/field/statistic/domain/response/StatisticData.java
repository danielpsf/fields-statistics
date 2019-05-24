package com.danielpsf.labs.field.statistic.domain.response;

public class StatisticData {

    private Float min;
    private Float max;
    private Double avg;

    public StatisticData() {
    }

    public StatisticData(Float min, Float max, Double avg) {
        this.min = min;
        this.max = max;
        this.avg = avg;
    }

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

    public static class Builder {
        private StatisticData statisticData = new StatisticData();

        public Builder withMin(Float min) {
            this.statisticData.setMin(min);
            return this;
        }

        public Builder witMax(Float min) {
            this.statisticData.setMin(min);
            return this;
        }

        public Builder withAvg(Double avg) {
            this.statisticData.setAvg(avg);
            return this;
        }

        public StatisticData build() {
            return this.statisticData;
        }
    }
}

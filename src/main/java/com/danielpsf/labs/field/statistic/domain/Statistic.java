package com.danielpsf.labs.field.statistic.domain;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
public class Statistic {

    private Long id;
    private Date occurrenceAt;
    private Float vegetation;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getOccurrenceAt() {
        return occurrenceAt;
    }

    public void setOccurrenceAt(Date occurrenceAt) {
        this.occurrenceAt = occurrenceAt;
    }

    public Float getVegetation() {
        return vegetation;
    }

    public void setVegetation(Float vegetation) {
        this.vegetation = vegetation;
    }

    public static class Builder {
        private Statistic statistic = new Statistic();

        public Builder withId(Long id) {
            this.statistic.setId(id);
            return this;
        }

        public Builder withOccurrenceAt(Date occurrenceAt) {
            this.statistic.setOccurrenceAt(occurrenceAt);
            return this;
        }

        public Builder withVegetation(Float vegetation) {
            this.statistic.setVegetation(vegetation);
            return this;
        }

        public Statistic build() {
            return this.statistic;
        }
    }
}

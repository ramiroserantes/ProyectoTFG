package com.proyect.tfg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Stats {

    @Id
    private String statName;
    private BigDecimal statValue;

    public Stats () {}

    public Stats(String statName, BigDecimal statValue) {
        this.statName = statName;
        this.statValue = statValue;
    }

    public String getStatName() { return statName; }

    public void setStatName(String statName) { this.statName = statName; }

    public BigDecimal getStatValue() { return statValue; }

    public void setStatValue(BigDecimal statValue) { this.statValue = statValue; }
}

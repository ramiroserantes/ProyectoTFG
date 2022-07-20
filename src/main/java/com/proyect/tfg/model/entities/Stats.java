package com.proyect.tfg.model.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Stats {

    @Id
    private String statName;
    private BigDecimal statValue;

    private User user;

    public Stats () {}

    public Stats(String statName, BigDecimal statValue) {
        this.statName = statName;
        this.statValue = statValue;
    }

    public String getStatName() { return statName; }

    public void setStatName(String statName) { this.statName = statName; }

    public BigDecimal getStatValue() { return statValue; }

    public void setStatValue(BigDecimal statValue) { this.statValue = statValue; }

    /**************************************** Relations ************************************************************/

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

}

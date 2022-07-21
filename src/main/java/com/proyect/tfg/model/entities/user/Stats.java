package com.proyect.tfg.model.entities.user;

import com.proyect.tfg.model.entities.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Stats implements Serializable {

    @Id
    private String statName;
    private BigDecimal statValue;

    private User user;

    public Stats () {}

    public Stats(User user, String statName, BigDecimal statValue) {
        this.user = user;
        this.statName = statName;
        this.statValue = statValue;
    }

    public String getStatName() { return statName; }

    public void setStatName(String statName) { this.statName = statName; }

    public BigDecimal getStatValue() { return statValue; }

    public void setStatValue(BigDecimal statValue) { this.statValue = statValue; }

    /**************************************** Relations ************************************************************/

    @ManyToOne(optional=false, fetch = FetchType.EAGER)
    @Id
    @JoinColumn(name = "userId")
    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

}

package com.proyect.tfg.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TopicCategory {

    @Id
    private Long id;
    private String name;

    public TopicCategory () {}

    public TopicCategory(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}

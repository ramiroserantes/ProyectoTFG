package com.proyect.tfg.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    private Long id;

    private String name;
    private String description;
    private String link;

    public Category () {}

    public Category(String name, String description, String link) {
        this.name = name;
        this.description = description;
        this.link = link;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getLink() { return link; }

    public void setLink(String link) { this.link = link; }
}

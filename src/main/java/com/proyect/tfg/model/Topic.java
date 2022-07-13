package com.proyect.tfg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Topic {

    @Id
    private Long id;

    private LocalDateTime postedDate;
    private String header;
    private String content;

    private int views;

    public Topic () {}

    public Topic(LocalDateTime postedDate, String header, String content, int views) {
        this.postedDate = postedDate;
        this.header = header;
        this.content = content;
        this.views = views;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public LocalDateTime getPostedDate() { return postedDate; }

    public void setPostedDate(LocalDateTime postedDate) { this.postedDate = postedDate; }

    public String getHeader() { return header; }

    public void setHeader(String header) { this.header = header; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public int getViews() { return views; }

    public void setViews(int views) { this.views = views; }
}

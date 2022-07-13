package com.proyect.tfg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Reply {

    @Id
    private Long id;

    private String content;
    private Boolean isEdited;

    private LocalDateTime postedDate;
    private LocalDateTime editedDate;

    public Reply () {}

    public Reply(String content, Boolean isEdited, LocalDateTime postedDate,
                 LocalDateTime editedDate) {
        this.content = content;
        this.isEdited = isEdited;
        this.postedDate = postedDate;
        this.editedDate = editedDate;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public Boolean getEdited() { return isEdited; }

    public void setEdited(Boolean edited) { isEdited = edited; }

    public LocalDateTime getPostedDate() { return postedDate; }

    public void setPostedDate(LocalDateTime postedDate) { this.postedDate = postedDate; }

    public LocalDateTime getEditedDate() { return editedDate; }

    public void setEditedDate(LocalDateTime editedDate) { this.editedDate = editedDate; }
}

package com.proyect.tfg.model.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reply {

    private Long id;

    private String content;
    private Boolean isEdited;

    private LocalDateTime postedDate;
    private LocalDateTime editedDate;

    private Topic topic;
    private User user;

    public Reply () {}

    public Reply(String content, Boolean isEdited, LocalDateTime postedDate,
                 LocalDateTime editedDate) {
        this.content = content;
        this.isEdited = isEdited;
        this.postedDate = postedDate;
        this.editedDate = editedDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    /**************************************** Relations ************************************************************/

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name = "topicId")
    public Topic getTopic() { return topic; }

    public void setTopic(Topic topic) { this.topic = topic; }

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}

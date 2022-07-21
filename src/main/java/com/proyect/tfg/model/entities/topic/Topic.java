package com.proyect.tfg.model.entities.topic;

import com.proyect.tfg.model.entities.user.User;
import com.proyect.tfg.model.entities.reply.Reply;
import com.proyect.tfg.model.entities.topicCategory.TopicCategory;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Topic {

    private Long id;

    private LocalDateTime postedDate;
    private String header;
    private String content;

    private int views;

    private User user;
    private TopicCategory topicCategory;
    private Set<Reply> replies = new HashSet<>();

    public Topic () {}

    public Topic(User user, TopicCategory topicCategory, LocalDateTime postedDate, String header, String content, int views) {
        this.user = user;
        this.topicCategory = topicCategory;
        this.postedDate = postedDate;
        this.header = header;
        this.content = content;
        this.views = views;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    /**************************************** Relations ************************************************************/

    @ManyToOne(optional=false, fetch=FetchType.LAZY)
    @JoinColumn(name="userId")
    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    @ManyToOne(optional=false, fetch=FetchType.LAZY)
    @JoinColumn(name="topicCategoryId")
    public TopicCategory getTopicCategory() { return topicCategory; }

    public void setTopicCategory(TopicCategory topicCategory) { this.topicCategory = topicCategory; }

    @OneToMany(mappedBy = "topic")
    public Set<Reply> getReplies() { return replies; }

    public void setReplies(Set<Reply> replies) { this.replies = replies; }
}

package com.hkimbrough22.forum.models;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    long userId;
    String textBody;

    @ManyToOne
    ForumUser myUser;

    protected Post(){}

    public Post(long userId, String textBody, ForumUser myUser) {
        this.userId = userId;
        this.textBody = textBody;
        this.myUser = myUser;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public ForumUser getMyUser() {
        return myUser;
    }

    public void setMyUser(ForumUser myUser) {
        this.myUser = myUser;
    }
}

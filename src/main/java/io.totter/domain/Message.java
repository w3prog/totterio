package io.totter.domain;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String text;
    private String tag;

    public Message() {

    }
    public Message(String text, String tags) {
        this.text = text;
        this.tag = tags;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTags() {
        return tag;
    }

    public void setTags(String tag) {
        this.tag = tag;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

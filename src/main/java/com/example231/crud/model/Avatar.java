package com.example231.crud.model;

import javax.persistence.*;

@Entity
@Table(name = "avatars")
public class Avatar {
    @Id
    @GeneratedValue
    private Long id;
    private String url;

    public Avatar() {

    }

    public Avatar(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}

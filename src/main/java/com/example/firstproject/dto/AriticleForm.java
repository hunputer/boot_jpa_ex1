package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;

public class AriticleForm {

    private String title;
    private String contents;

    public AriticleForm(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "AriticleForm{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }

    public Article toEntity() {
        return new Article(null, title, contents);

    }
}

package org;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Article {
    private int id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Article(int id, String title, String content) {
        LocalDateTime now = LocalDateTime.now();
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = now;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCreateDate() {
        return createDate.format(formatter);
    }
}

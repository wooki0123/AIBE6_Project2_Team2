package org;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Article {
    private int lastid = 0;
    private String title;
    private String content;
    private LocalDateTime createDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    Article(String title, String content) {
        LocalDateTime now = LocalDateTime.now();
        this.title = title;
        this.content = content;
        this.createDate = now;
    }

    public int getId() {
        return ++lastid;
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

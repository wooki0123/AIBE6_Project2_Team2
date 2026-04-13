package org;

import java.time.LocalDateTime;

public class Article {
    private int id;
    private String title;
    private String content;
    private LocalDateTime createDate;

    Article(String title, String content) {
        LocalDateTime now = LocalDateTime.now();
        this.title = title;
        this.content = content;
        this.createDate = now;
    }
}

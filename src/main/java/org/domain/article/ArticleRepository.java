package org.domain.article;

import org.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private int lastId = 0;
    private List<Article> articleList = new ArrayList<>();

    public Article save(Article article) {
        article.setId(++lastId);
        articleList.add(article);
        return article;
    }

    public List<Article> findAll() {
        return articleList.reversed();
    }
}

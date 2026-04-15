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

    public void delete(Article article) {
        articleList.remove(article);
    }

    public List<Article> findAll() {
        return articleList.reversed();
    }

    public Article findById(int id) {
        for (Article article : articleList) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }
}

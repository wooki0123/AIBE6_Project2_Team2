package org.domain.article;

import org.AppContext;
import org.Article;

import java.util.List;

public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService() {
         articleRepository = AppContext.articleRepository;
    }

    public void write(String title, String content) {
        Article article = new Article(title, content);
        articleRepository.save(article);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}

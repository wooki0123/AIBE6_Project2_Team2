package org.domain.article;

import org.Article;

import java.util.List;

public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void write(String title, String content) {
        Article article = new Article(title, content);
        articleRepository.save(article);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article findById(int id) {
        return articleRepository.findById(id);
    }

    public List<Article> search(String keyword) {
        return articleRepository.findByKeyword(keyword);
    }

    public boolean delete(int id) {
        Article article = articleRepository.findById(id);
        if (article == null) {
            return false;
        }
        articleRepository.delete(article);
        return true;
    }
}

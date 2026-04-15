package org;

import org.domain.article.ArticleController;
import org.domain.article.ArticleRepository;
import org.domain.article.ArticleService;
import org.domain.system.SystemController;

import java.util.Scanner;

public class AppContext {
    public static Scanner scanner;
    public static SystemController systemController;
    public static ArticleController articleController;
    public static ArticleService articleService;
    public static ArticleRepository articleRepository;

    static {
        scanner = new Scanner(System.in);
        articleRepository = new ArticleRepository();
        articleService = new ArticleService(articleRepository);
        articleController = new ArticleController(scanner, articleService);
        systemController = new SystemController();
    }
}

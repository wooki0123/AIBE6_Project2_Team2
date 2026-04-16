package org.domain.article;

import org.Article;
import org.Rq;

import java.util.List;
import java.util.Scanner;

public class ArticleController {
    private final Scanner scanner;
    private final ArticleService articleService;

    public ArticleController(Scanner scanner, ArticleService articleService) {
        this.scanner = scanner;
        this.articleService = articleService;
    }

    public void actionWrite() {
        System.out.print("제목: ");
        String title = scanner.nextLine().trim();
        System.out.print("내용: ");
        String content = scanner.nextLine().trim();

        articleService.write(title, content);

        System.out.println("=> 게시글이 등록되었습니다.");
    }

    public void actionList() {
        System.out.println("번호 | 제목       | 등록일");
        System.out.println("-----------------------------");
        for (Article article : articleService.findAll()) {
            System.out.println("%d | %s | %s".formatted(article.getId(), article.getTitle(), article.getCreateDate()));
        }
    }

    public void actionDetail(Rq rq) {
        if (!rq.hasArg()) {
            System.out.println("명령어를 확인해주세요.");
            return;
        }

        int articleId = rq.getArgAsInt();
        if (articleId == -1) {
            System.out.println("올바른 숫자를 입력해주세요.");
            return;
        }

        Article article = articleService.findById(articleId);

        if (article == null) {
            System.out.println("해당 번호의 게시글이 존재하지 않습니다.");
            return;
        }

        System.out.println("번호: %d".formatted(article.getId()));
        System.out.println("제목: %s".formatted(article.getTitle()));
        System.out.println("내용: %s".formatted(article.getContent()));
        System.out.println("등록일: %s".formatted(article.getCreateDate()));

    }

    public void actionUpdate(Rq rq) {
        if (!rq.hasArg()) {
            System.out.println("명령어를 확인해주세요.");
            return;
        }

        int articleId = rq.getArgAsInt();
        if (articleId == -1) {
            System.out.println("올바른 숫자를 입력해주세요.");
            return;
        }

        Article article = articleService.findById(articleId);

        if (article == null) {
            System.out.println("해당 번호의 게시글이 존재하지 않습니다.");
            return;
        }

        System.out.print("제목 (현재: %s): ".formatted(article.getTitle()));
        String title = scanner.nextLine().trim();
        System.out.print("내용 (현재: %s): ".formatted(article.getContent()));
        String content = scanner.nextLine().trim();

        article.setTitle(title);
        article.setContent(content);

        System.out.println("=> 게시글이 수정되었습니다.");
    }

    public void actionSearch(Rq rq) {
        if (!rq.hasArg()) {
            System.out.println("명령어를 확인해주세요.");
            return;
        }
        String keyword = rq.getArg();
        List<Article> results = articleService.search(keyword);

        if (results.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
            return;
        }

        System.out.println("번호 | 제목       | 등록일");
        System.out.println("-----------------------------");
        for (Article article : results) {
            System.out.println("%d | %s | %s".formatted(article.getId(), article.getTitle(), article.getCreateDate()));
        }
    }

    public void actionDelete(Rq rq) {
        if (!rq.hasArg()) {
            System.out.println("명령어를 확인해주세요.");
            return;
        }
        int articleId = rq.getArgAsInt();
        if (articleId == -1) {
            System.out.println("올바른 숫자를 입력해주세요.");
            return;
        }
        try {
            articleId = Integer.parseInt(rq.getArg());
        } catch (NumberFormatException e) {
            System.out.println("올바른 숫자를 입력해주세요.");
            return;
        }

        if (articleService.delete(articleId)) {
            System.out.println("=> 게시글이 삭제되었습니다.");
        } else {
            System.out.println("해당 번호의 게시글이 존재하지 않습니다.");
        }
    }
}

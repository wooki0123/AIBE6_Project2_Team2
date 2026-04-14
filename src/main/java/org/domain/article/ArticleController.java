package org.domain.article;

import org.AppContext;
import org.Article;

import java.util.Scanner;

public class ArticleController {
    private final Scanner scanner;
    private final ArticleService articleService;

    public ArticleController(Scanner scanner) {
        this.scanner = scanner;
        this.articleService = AppContext.articleService;
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

    public void actionDetail(String cmd) {
        String[] cmdBits = cmd.split(" ");
        if (cmdBits.length < 2) {
            System.out.println("명령어를 확인해주세요.");
            return;
        }

        int articleId = Integer.parseInt(cmdBits[1]);
        for (Article article : articleService.findAll()) {
            if (article.getId() == articleId) {
                System.out.println("번호: %d".formatted(article.getId()));
                System.out.println("제목: %s".formatted(article.getTitle()));
                System.out.println("내용: %s".formatted(article.getContent()));
                System.out.println("등록일: %s".formatted(article.getCreateDate()));
                return;
            }
        }
        System.out.println("해당 번호의 게시글이 존재하지 않습니다.");

    }

    public void actionUpdate(String cmd) {

    }

    public void actionDelete(String cmd) {
        String[] cmdBits = cmd.split(" ");
        if (cmdBits.length < 2) {
            System.out.println("명령어를 확인해주세요.");
            return;
        }

        int articleId = Integer.parseInt(cmdBits[1]);

        if (articleService.delete(articleId)) {
            System.out.println("=> 게시글이 삭제되었습니다.");
        } else {
            System.out.println("해당 번호의 게시글이 존재하지 않습니다.");
        }
    }
}

package org;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private int lastId = 0;
    private int articleId = 0;
    private List<Article> articleList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);;

    void run() {
        System.out.println("프로그램 실행");

        while (true) {
            System.out.print("명령어: ");
            String cmd  = scanner.nextLine().trim();
            String[] cmdBits = cmd.split(" ");
            String actionName = cmdBits[0];

            switch (actionName) {
                case "write" -> actionWrite();
                case "list" -> actionList();
                case "detail" -> actionDetail(cmd);
                case "update" -> actionUpdate(cmd);
                case "delete" -> actionDelete(cmd);
                case "exit" -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }

            }
        }
    }

    void actionWrite() {
        System.out.print("제목: ");
        String title = scanner.nextLine().trim();
        System.out.print("내용: ");
        String content = scanner.nextLine().trim();

        ++lastId;

        Article article = new Article(lastId, title, content);

        articleList.add(article);

        System.out.println("=> 게시글이 등록되었습니다.");
    }

    void actionList() {
        System.out.println("번호 | 제목       | 등록일");
        System.out.println("-----------------------------");
        for (int i = articleList.size() - 1; i >= 0; i--) {
            Article article = articleList.get(i);
            System.out.println("%d | %s | %s".formatted(article.getId(), article.getTitle(), article.getCreateDate()));
        }
    }

    void actionDetail(String cmd) {
        String[] cmdBits = cmd.split(" ");
        if (cmdBits.length < 2) {
            System.out.println("명령어를 확인해주세요.");
            return;
        }

        int articleId = Integer.parseInt(cmdBits[1]);
        for (Article article : articleList) {
            if (article.getId() == articleId) {
                System.out.println("번호: %d".formatted(article.getId()));
                System.out.println("제목: %s".formatted(article.getTitle()));
                System.out.println("내용: %s".formatted(article.getContent()));
                System.out.println("등록일: %s".formatted(article.getCreateDate()));
                return;
            } else {
                System.out.println("해당 번호의 게시글이 존재하지 않습니다.");
                return;
            }
        }

    }

    void actionUpdate(String cmd) {

    }

    void actionDelete(String cmd) {

    }
}

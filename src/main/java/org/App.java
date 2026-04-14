package org;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private int lastId = 0;
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
                case "write":
                    actionWrite();
                    break;
                case "list":
                    actionList();
                    break;
                case "detail":
                    actionDetail(cmd);
                    break;
                case "update":
                    actionUpdate(cmd);
                    break;
                case "delete":
                    actionDelete(cmd);
                    break;
                case "exit":
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }
    }

    void actionWrite() {
        System.out.print("제목: ");
        String title = scanner.nextLine().trim();
        System.out.print("내용: ");
        String content = scanner.nextLine().trim();

        Article article = new Article(title, content);
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

    }

    void actionUpdate(String cmd) {

    }

    void actionDelete(String cmd) {

    }
}

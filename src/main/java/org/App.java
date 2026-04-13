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
            String cmd = scanner.nextLine().trim();
            switch (cmd) {
                case "write":
                    actionWrite();
                    break;
                case "list":
                    actionList();
                    break;
//                case "detail" + lastId:
//                    actionDetail(lastId);
//                    break;
                case "update":
                    break;
                case "delete":
                    break;
                case "exit":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("알 수 없는 명령어입니다.");
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

    void actionDetail(int id) {

            Article article = articleList.get(id);
            System.out.println("번호: %d".formatted(article.getId()));
            System.out.println("제목: %s".formatted(article.getTitle()));
            System.out.println("내용: %s".formatted(article.getContent()));
            System.out.println("등록일: %s".formatted(article.getCreateDate()));

    }
}

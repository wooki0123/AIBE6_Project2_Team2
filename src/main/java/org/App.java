package org;

import org.domain.article.ArticleController;
import org.domain.system.SystemController;

import java.util.Scanner;

public class App {
    private final Scanner scanner;


    public App() {
        this.scanner = AppContext.scanner;
    }
    void run() {
        SystemController systemController = AppContext.systemController;
        ArticleController articleController = AppContext.articleController;

        System.out.println("프로그램 실행");

        while (true) {
            System.out.print("명령어: ");
            String cmd  = scanner.nextLine().trim();
            Rq rq = new Rq(cmd);

            switch (rq.getActionName()) {
                case "write" -> articleController.actionWrite();
                case "list" -> articleController.actionList();
                case "detail" -> articleController.actionDetail(rq);
                case "update" -> articleController.actionUpdate(rq);
                case "delete" -> articleController.actionDelete(rq);
                case "search" -> articleController.actionSearch(rq);
                case "exit" -> {
                    systemController.actionExit();
                    return;
                }
                default -> System.out.println("알 수 없는 명령어입니다: " + rq.getActionName());
            }
        }
    }
}

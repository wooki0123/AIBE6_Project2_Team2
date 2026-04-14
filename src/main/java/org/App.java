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
            String[] cmdBits = cmd.split(" ");
            String actionName = cmdBits[0];

            switch (actionName) {
                case "write" -> articleController.actionWrite();
                case "list" -> articleController.actionList();
                case "detail" -> articleController.actionDetail(cmd);
                case "update" -> articleController.actionUpdate(cmd);
                case "delete" -> articleController.actionDelete(cmd);
                case "exit" -> {
                    systemController.actionExit();
                    return;
                }

            }
        }
    }
}

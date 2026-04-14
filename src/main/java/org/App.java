package org;

import org.domain.article.ArticleController;
import org.domain.system.SystemController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private int lastId = 0;
    private int articleId = 0;
    private List<Article> articleList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    SystemController systemController = new SystemController();
    ArticleController articleController = new ArticleController(scanner);

    void run() {
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

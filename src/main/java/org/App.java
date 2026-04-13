package org;

import java.util.Scanner;

public class App {
    void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("프로그램 실행");
        System.out.print("명령어: ");
        String cmd = scanner.nextLine().trim();
        System.out.println("입력된 명령어: " + cmd);

        while (true) {
            switch (cmd) {
                case "write":
                    break;
                case "list":
                    break;
                case "detail":
                    break;
                case "update":
                    break;
                case "delete":
                    break;
                default:
                    System.out.println("알 수 없는 명령어입니다.");
            }
        }
    }

}

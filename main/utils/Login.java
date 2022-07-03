package main.utils;

import java.util.Scanner;

public class Login {
    public static final String LOGIN = "admin";
    public static final String PASSWORD = "1111";

    public static boolean auth() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter login: ");
        String login = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        return login.equals(LOGIN) & password.equals(PASSWORD);
    }
}

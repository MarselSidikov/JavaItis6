package ru.itis;

import java.util.Scanner;

public class Main {

    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        ConsoleUtils.clearConsole();
        System.out.println(ANSI_RED + "Hello" + ANSI_RED);
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        ConsoleUtils.clearConsole();
        int j = scanner.nextInt();
    }
}

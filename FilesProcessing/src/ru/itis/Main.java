package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        WordFinder finder = new WordFinder();

        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        long startTime = System.currentTimeMillis();
        finder.findCountOfWordInFolder(word, "files");
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
    }
}

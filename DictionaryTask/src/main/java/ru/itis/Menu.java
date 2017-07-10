package ru.itis;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    private Dictionary dictionary;

    public Menu(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("МЕНЮ:");
        System.out.println("1. Показать словарь");
        System.out.println("2. Добавить слово");
        System.out.println("3. Выход");
    }

    public void getCommand() {
        int command = scanner.nextInt();
        switch (command) {
            case 1: showDictionary(); break;
            case 2: addWord(); break;
            case 3: System.exit(0);
        }
    }

    private void showDictionary() {
        dictionary.show();
    }

    private void addWord() {
        String word = scanner.next();
        dictionary.addWord(word);
    }
}

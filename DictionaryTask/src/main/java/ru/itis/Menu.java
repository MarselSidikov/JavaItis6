package ru.itis;

import java.util.Scanner;

// класс Меню
public class Menu {
    // сканнер для считывания комманд и слов
    private Scanner scanner;

    // словарь
    private Dictionary dictionary;

    // конструктор - принимает на вход какой-либо словарь
    public Menu(Dictionary dictionary) {
        // подставляет внешний словарь в наше меню
        this.dictionary = dictionary;
        // создаем сканнер для чтения с консоли
        this.scanner = new Scanner(System.in);
    }

    // метод вывода меню на экран
    public void showMenu() {
        System.out.println("МЕНЮ:");
        System.out.println("1. Показать словарь");
        System.out.println("2. Добавить слово");
        System.out.println("3. Выход");
    }
    // метод получения команды
    public void getCommand() {
        // считываем команду
        int command = scanner.nextInt();
        // смотрим, какая у нас команда
        switch (command) {
            // показываем словарь
            case 1: showDictionary(); break;
            // добавляем слово
            case 2: addWord(); break;
            // выходим из программы
            case 3: System.exit(0);
        }
    }

    private void showDictionary() {
        dictionary.show();
    }

    private void addWord() {
        // считываем с помощью сканера слово
        String word = scanner.next();
        // добавляем в словарь
        dictionary.addWord(word);
    }
}

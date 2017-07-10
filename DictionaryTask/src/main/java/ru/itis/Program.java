package ru.itis;

public class Program {
    public static void main(String[] args) {
        // создали словарь
        Dictionary dictionary = new Dictionary();
        // соаздали меню и передали словарь
        Menu menu = new Menu(dictionary);
        // бесконечный цикл
        while (true) {
            // выводим меню
            menu.showMenu();
            // считали команду
            menu.getCommand();
        }
    }
}

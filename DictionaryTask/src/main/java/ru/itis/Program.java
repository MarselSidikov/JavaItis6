package ru.itis;

public class Program {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Menu menu = new Menu(dictionary);
        while (true) {
            menu.showMenu();
            menu.getCommand();
        }
    }
}

package ru.itis;

public class Dictionary {
    private int MAX_LETTERS_COUNT = 33;

    private Node[] nodes;

    public Dictionary() {
        nodes = new Node[MAX_LETTERS_COUNT];
    }

    public void addWord(String word) {
        // определить первый символ слова
        // определить индекс, куда мы положим слово
        System.out.println("Слово добавлено");
    }

    public void show() {
        // А
        // амир
        // адель
        // арслан
        // Б
        // Леонид
        System.out.println("Словарь показан");
    }
}

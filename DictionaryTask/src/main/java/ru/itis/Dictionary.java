package ru.itis;

public class Dictionary {
    private int MAX_LETTERS_COUNT = 32;

    private Node[] nodes;

    public Dictionary() {
        nodes = new Node[MAX_LETTERS_COUNT];
    }

    public void addWord(String word) {
        int position = word.charAt(0) - 'А';

        Node newNode = new Node(word.charAt(0), word);
        if (nodes[position] == null) {
            nodes[position] = newNode;
        } else {
            newNode.setNext(nodes[position]);
            nodes[position] = newNode;
        }
    }

    public void show() {
        System.out.println("Словарь");
        for (int i = 0; i < MAX_LETTERS_COUNT; i++) {
            if (nodes[i] != null) {
                char letter = (char)('А' + i);
                System.out.println(letter + ":");
                Node currentNode = nodes[i];
                while (currentNode != null) {
                    System.out.println(currentNode.getValue());
                    currentNode = currentNode.getNext();
                }
            }
        }
    }
}

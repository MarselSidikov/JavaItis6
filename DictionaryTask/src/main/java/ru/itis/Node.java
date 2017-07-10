package ru.itis;

public class Node {
    private char key;
    private String value;
    private Node next;

    public Node(char key, String value) {
        this.key = key;
        this.value = value;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

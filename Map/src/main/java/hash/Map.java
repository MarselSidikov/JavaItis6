package hash;

import java.util.HashMap;

public class Map {
    private final int MAX_ARRAYS_SIZE = 16;
    private Node nodes[];

    private int count;

    public Map() {
        this.nodes = new Node[MAX_ARRAYS_SIZE];
        this.count = 0;
    }

    public void put(String key, String value) {
        int position = (MAX_ARRAYS_SIZE - 1) & hash(key);
        // если в корзинке с номером position ничего нет
        Node newNode = new Node(key, value);
        if (nodes[position] == null) {
            nodes[position] = newNode;
        } else {
            Node currentNode = nodes[position];
            while (currentNode.getNext() != null) {
                if (currentNode.getKey().equals(key)) {
                    currentNode.setValue(value);
                    return;
                }
                currentNode = currentNode.getNext();
            }
            if (currentNode.getKey().equals(key)) {
                currentNode.setValue(value);
                return;
            }
            currentNode.setNext(newNode);
        }
    }

    public String get(String key) {
        int position = (MAX_ARRAYS_SIZE - 1) & hash(key);
        if (nodes[position] == null) {
            return null;
        } else {
            Node currentNode = nodes[position];
            while (currentNode != null) {
                if (currentNode.getKey().equals(key)) {
                    return currentNode.getValue();
                } else {
                    currentNode = currentNode.getNext();
                }
            }
        }
        return null;
    }

    private int hash(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum + s.charAt(i);
        }
        return sum;
    }

    public void show() {
        for (int i = 0; i < MAX_ARRAYS_SIZE; i++) {
            System.out.print("[" + i + "]");
            if (nodes[i] == null) {
            } else {
                Node currentNode = nodes[i];
                while (currentNode != null) {
                    System.out.print(" -> (" + currentNode.getKey() + "," + currentNode.getValue() + ")" );
                    currentNode = currentNode.getNext();
                }
            }
            System.out.println();
        }
    }
}

package hash;

public class Map {
    private final int MAX_ARRAYS_SIZE = 10;
    private Node nodes[];

    private int count;

    public Map() {
        this.nodes = new Node[MAX_ARRAYS_SIZE];
        this.count = 0;
    }

    public void put(String key, String value) {
        int position = hash(key) % MAX_ARRAYS_SIZE;
        // если в корзинке с номером position ничего нет
        Node newNode = new Node(key, value);
        if (nodes[position] == null) {
            nodes[position] = newNode;
        } else {
            newNode.setNext(nodes[position]);
            nodes[position] = newNode;
        }
    }

    public String get(String key) {
        int position = hash(key) % MAX_ARRAYS_SIZE;
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

}

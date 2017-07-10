package amir;

public class Map {
    private final int MAX_ARRAYS_SIZE = 10;
    // массив ключей
    private String keys[];
    // массив значений
    private String values[];

    private int count;

    public Map() {
        this.keys = new String[MAX_ARRAYS_SIZE];
        this.values = new String[MAX_ARRAYS_SIZE];
        this.count = 0;
    }

    // кладем в карту под ключем key
    // значение value
    public void put(String key, String value) {
        if (count < MAX_ARRAYS_SIZE) {
            keys[count] = key;
            values[count] = value;
            count++;
        } else throw new IllegalArgumentException("Места нет");
    }

    public String get(String key) {
        for (int i = 0; i < count; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }
}

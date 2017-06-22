package ru.itis;

public class ArrayList {
    // контстанта - final
    private final int MAX_ARRAY_SIZE = 5;
    // поле класса - массив элементов
    // мы не хотим предоставлять доступ к данному
    // полю, поскольку его могут использовать неэффективно
    private int elements[];
    // количество элементов списка
    private int count;

    public ArrayList() {
        this.elements = new int[MAX_ARRAY_SIZE];
        this.count = 0;
    }

    // метод добавления элемента element в список
    public void add(int element) {
        // пока есть место для того, чтобы положить
        if (count < MAX_ARRAY_SIZE){
            this.elements[count] = element;
            count++;
        } else {
            System.err.println("Нет места");
        }
    }

    public int getElementByIndex(int index) {
        // если запрашиваемый элемент
        // действительно существует
        if (index < count) {
            return this.elements[index];
        } else {
            System.err.println("Неверный индекс");
            return -1;
        }
    }


}

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

    /*
    Пусть есть список
    [2][3][5][6][0][0]
    add(7,2);
    [2][3][7][5][6][0]
     */
    public void add(int element, int index) {
        if (count < MAX_ARRAY_SIZE &&
                index < count) {
            for (int i = count; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            count++;
        } else {
            System.err.println("Все плохо");
        }
    }

    public void remove(int index) {

    }

    public static ArrayList merge(ArrayList a, ArrayList b) {
        return null;
    }



}

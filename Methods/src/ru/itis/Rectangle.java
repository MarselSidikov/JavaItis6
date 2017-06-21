package ru.itis;

public class Rectangle {
    // поля, содержат информацию о состоянии объекта
    int a;
    int b;
    // конструктор - механизм,
    // позволяющий задавать начальное состояние созданного объекта
    Rectangle(int A, int B) {
        a = A;
        b = B;
    }

    int area() {
        return a * b;
    }
}

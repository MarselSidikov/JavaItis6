package ru.itis;


public class Rectangle {
    private int a;
    private int b;

    public Rectangle(int a, int b) {
        if (a > 0) {
            this.a = a;
        }
        if (b > 0) {
            this.b = b;
        }
    }

    public int area() {
        return a * b;
    }
}

package ru.itis;


public class Rectangle extends Figure {
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

    // метод area есть в классе Figure, но мы
    // его здесь переопределили
    // то есть area есть и у треугольника
    // и у прямоугольника, но они
    // реализованы по-разному
    public double area() {
        return a * b;
    }
}

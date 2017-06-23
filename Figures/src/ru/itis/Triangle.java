package ru.itis;

public class Triangle extends Figure {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        if (isCorrectTriangle(a, b,c)) {
            this.a = a ;
            this.b = b;
            this.c = c;
        }
    }

    public double area() {
        double p = (a + b + c) * 0.5;
        return Math.sqrt(p * (p - a)
        * (p - b) * (p - c));
    }

    private boolean isCorrectTriangle(int a, int b, int c) {
        return !(a < 0 ||
                b < 0 ||
                c < 0) &&
                a < (b + c) &&
                b < (a + c) &&
                c < (a + b);
    }
}

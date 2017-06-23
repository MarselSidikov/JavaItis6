package ru.itis;

/**
 * Created by admin on 23.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(4, 5);
        System.out.println(r.area());
        Square s = new Square(4);
        System.out.println(s.area());
    }
}

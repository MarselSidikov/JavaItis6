package ru.itis;

public class Main {
    public static void main(String[] args) {
        // r,s,t - объектные переменные,
        // в отличие от обычных переменных
        // хранят ссылку на реальный объект
        // обычные переменные - само значение
        Rectangle r = new Rectangle(4, 5);
        Rectangle r1 = new Rectangle(10, 2);
        System.out.println(r.area());
        Square s = new Square(4);
        Square s2 = new Square(5);
        System.out.println(s.area());
        Triangle t = new Triangle(3, 4, 5);
        System.out.println(t.area());
        // восходящее преобразования
        // возможность присвоить объектной переменной типа
        // класса предка, ссылку на объект класса потомка
        // Rectangle r1 = s;
        Figure figures[] = {r, s, r1, s2, t};
        for (int i  = 0; i < figures.length; i++) {
            System.out.println(figures[i].area());
        }
        // поскольку класс Figure - абстрактный
        // нельзя создать его объект
        // Figure figure = new Figure();
    }
}

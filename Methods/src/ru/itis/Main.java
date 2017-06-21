package ru.itis;

public class Main {

    public static void main(String[] args) {
        Rectangle r = new Rectangle(5, 6);
        Rectangle r1 = new Rectangle(2, 3);
        Rectangle r2 = new Rectangle(4, 3);
        Rectangle r3 = new Rectangle(1, 2);
        Rectangle r4 = new Rectangle(5, 5);
        Rectangle r5 = new Rectangle(4, 1);
        Rectangle r6 = new Rectangle(2, 8);

        Rectangle rectangles[] = {r, r1, r2, r3, r4, r5, r6};

        for (int i = rectangles.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (rectangles[j].area() < rectangles[j + 1].area()) {
                    Rectangle temp = rectangles[j];
                    rectangles[j] = rectangles[j + 1];
                    rectangles[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < rectangles.length; i++) {
            System.out.println(rectangles[i].a +
                    "*" + rectangles[i].b + "=" +
            rectangles[i].area());
        }

    }
}

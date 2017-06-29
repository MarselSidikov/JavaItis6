package ru.itis;

public class NumbersThread extends Thread {
    private int number;

    public NumbersThread(int number) {
        this.number = number;
    }

    // данынй метод определяет, что будет делать этот поток
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(number);
        }
    }
}

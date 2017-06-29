package ru.itis;

public class Main {

    public static void main(String[] args) {
	    NumbersThread numbersThread1 = new NumbersThread(5);
	    NumbersThread numbersThread2 = new NumbersThread(6);

	    // запускаем потоки
	    numbersThread1.start();
	    numbersThread2.start();
    }
}

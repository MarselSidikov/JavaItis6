package ru.itis;

public class MainForCalcer {
    public static void main(String[] args) {
        Calcer calcer = new Calcer();
        calcer.readNumbers(10);
        int result = calcer.calcR();
        System.out.println(result);
    }
}

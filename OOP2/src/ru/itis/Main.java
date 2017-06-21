package ru.itis;

public class Main {

    public static void main(String[] args) {
        Student adelya = new Student("Adelya", 90, 92, 90);
        // adelya.physicsMark = -15;
        double result = adelya.calcAverage();
        System.out.println(result);
        System.out.println(adelya.getPhysicsMark());
    }
}

package ru.itis;

public class Student {
    String name;
    private int russianLanguageMark;
    private int mathMark;
    private int physicsMark;

    Student(String name, int russianLanguageMark,
            int mathMark, int physicsMark) {
        this.name = name;
        if (russianLanguageMark >= 0 && russianLanguageMark <= 100) {
            this.russianLanguageMark = russianLanguageMark;
        } else {
            System.err.println("Неверный балл за русский язык");
        }
        if (mathMark >= 0 && mathMark <= 100) {
            this.mathMark = mathMark;
        } else {
            System.err.println("Неверный балл за математику");
        }
        if (physicsMark >= 0 && physicsMark <= 100) {
            this.physicsMark = physicsMark;
        } else {
            System.err.println("Неверный балл за физику");
        }
    }

    double calcAverage() {
        return (russianLanguageMark +
                mathMark + physicsMark) / 3.0;
    }

    public int getPhysicsMark() {
        return physicsMark;
    }
}

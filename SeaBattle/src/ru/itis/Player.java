package ru.itis;

// класс, описывающий игрока
public class Player {
    // имя
    private String name;
    // поле
    private PlayingField field;

    // конструктор
    public Player(String name, PlayingField field) {
        this.name = name;
        this.field = field;
    }

    // выстрел
    public PlayingField.ShotState shot(int x, int y) {
        return field.shot(x,y);
    }

    public String getName() {
        return name;
    }

    public PlayingField getField() {
        return field;
    }
}

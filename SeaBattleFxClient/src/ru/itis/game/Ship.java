package ru.itis.game;

// лодка
public class Ship {
    // перечисление - типа лодок
    public enum ShipType {
        Boat,
        Destroyer,
        Cruiser,
        Battleship
    }
    // координаты лодки
    private int X;
    private int Y;
    // ориентация лодки
    private boolean isHorizontal;
    // тип лодки
    private ShipType type;
    // количество палуб
    private int numberOfDecks;

    // конструктор
    public Ship(int x, int y, boolean isHorizontal, ShipType type) {
        X = x - 1;
        Y = y - 1;
        this.isHorizontal = isHorizontal;
        this.type = type;
        // количество палуб
        this.numberOfDecks = type.ordinal() + 1;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public ShipType getType() {
        return type;
    }

    public int getNumberOfDecks() {
        return numberOfDecks;
    }
    // выстрел в лодку
    public void shot() {
        // уменьшаем количество палуб
        this.numberOfDecks = this.numberOfDecks - 1;
    }
}

package ru.itis;

public class Ship {
    // перечисление
    public enum ShipType {
        Boat,
        Destroyer,
        Cruiser,
        Battleship
    }

    private int X;
    private int Y;
    private boolean isHorizontal;
    private ShipType type;
    private int numberOfDecks;

    public Ship(int x, int y, boolean isHorizontal, ShipType type) {
        X = x - 1;
        Y = y - 1;
        this.isHorizontal = isHorizontal;
        this.type = type;
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

    public void shot() {
        this.numberOfDecks = this.numberOfDecks - 1;
    }
}

package ru.itis;

import java.util.ArrayList;

public class PlayingField {
    private final int FIELD_SIZE = 10;
    // список кораблей
    private ArrayList<Ship> ships = new ArrayList<>();
    private int field[][] = new int[FIELD_SIZE][FIELD_SIZE];

    public void addShip(Ship ship) {
        if (ship.getX() < FIELD_SIZE &&
                ship.getX() >= 0 &&
                ship.getY() < FIELD_SIZE &&
                ship.getY() >= 0 &&
                (ship.isHorizontal() && (ship.getX() + ship.getNumberOfDecks() < FIELD_SIZE)) ||
                (!ship.isHorizontal() && (ship.getY() + ship.getNumberOfDecks() < FIELD_SIZE))) {
            ships.add(ship);
            if (!ship.isHorizontal()) {
                for (int i = ship.getY(); i < ship.getY() + ship.getNumberOfDecks(); i++) {
                    field[ship.getY()][i] = ship.getType().ordinal() + 1;
                }
            } else {
                for (int j = ship.getX(); j < ship.getX() + ship.getNumberOfDecks(); j++) {
                    field[j][ship.getX()] = ship.getType().ordinal() + 1;
                }
            }
        }
    }

    public void showOnConsole() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }


}

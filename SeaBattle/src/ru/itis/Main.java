package ru.itis;

public class Main {

    public static void main(String[] args) {
	    Ship a = new Ship(4, 5, true, Ship.ShipType.Boat);
	    Ship b = new Ship(3, 3, false, Ship.ShipType.Boat);
	    Ship c = new Ship(6, 6, false, Ship.ShipType.Cruiser);
	    Ship d = new Ship(9, 0, false, Ship.ShipType.Destroyer);
	    PlayingField field = new PlayingField();
	    field.addShip(a);
	    field.addShip(b);
	    field.addShip(c);
	    field.addShip(d);
	    field.showOnConsole();

    }
}

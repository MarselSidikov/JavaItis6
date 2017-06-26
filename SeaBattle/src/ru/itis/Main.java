package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Ship a = new Ship(1, 5, true, Ship.ShipType.Boat);
	    Ship b = new Ship(2, 3, true, Ship.ShipType.Battleship);
	    Ship c = new Ship(2, 7, true, Ship.ShipType.Boat);
	    Ship d = new Ship(2, 9, true, Ship.ShipType.Destroyer);
	    Ship e = new Ship(4, 6, true, Ship.ShipType.Cruiser);
	    Ship f = new Ship(6, 9, false, Ship.ShipType.Destroyer);
	    Ship g = new Ship(8, 2, false, Ship.ShipType.Destroyer);
	    Ship h = new Ship(8, 10, true, Ship.ShipType.Boat);
	    Ship i = new Ship(9, 6, false, Ship.ShipType.Cruiser);
	    Ship j = new Ship(10, 3, true, Ship.ShipType.Boat);

	    PlayingField field = new PlayingField();
		field.addShip(a);
		field.addShip(b);
		field.addShip(c);
		field.addShip(d);
		field.addShip(e);
		field.addShip(f);
		field.addShip(g);
		field.addShip(h);
		field.addShip(i);
		field.addShip(j);
		field.showOnConsole();

		Player player = new Player("Amir", field);
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			System.out.println(player.shot(x, y));
			field.showOnConsole();
		}
    }
}

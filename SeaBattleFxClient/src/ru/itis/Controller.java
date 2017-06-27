package ru.itis;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import ru.itis.game.PlayingField;
import ru.itis.game.Ship;

public class Controller {

    @FXML
    private AnchorPane pane;

    @FXML
    private Rectangle boatRect;

    @FXML
    private Rectangle destroyerRect;

    private PlayingField field;

    private Rectangle rectanglesField[][];

    private PlayingField enemyField;

    private Ship.ShipType currentType;

    @FXML
    public void initialize() {
        rectanglesField = new Rectangle[10][10];
        boatRect.setOnMouseClicked(event -> {
            currentType = Ship.ShipType.Boat;
        });

        destroyerRect.setOnMouseClicked(event -> {
            currentType = Ship.ShipType.Destroyer;
        });

//        Ship a = new Ship(1, 5, true, Ship.ShipType.Boat);
//        Ship b = new Ship(2, 3, true, Ship.ShipType.Battleship);
//        Ship c = new Ship(2, 7, true, Ship.ShipType.Boat);
//        Ship d = new Ship(2, 9, true, Ship.ShipType.Destroyer);
//        Ship e = new Ship(4, 6, true, Ship.ShipType.Cruiser);
//        Ship f = new Ship(6, 9, false, Ship.ShipType.Destroyer);
//        Ship g = new Ship(8, 2, false, Ship.ShipType.Destroyer);
//        Ship h = new Ship(8, 10, true, Ship.ShipType.Boat);
//        Ship z = new Ship(9, 6, false, Ship.ShipType.Cruiser);
//        Ship k = new Ship(10, 3, true, Ship.ShipType.Boat);

        field = new PlayingField();
//        field.addShip(a);
//        field.addShip(b);
//        field.addShip(c);
//        field.addShip(d);
//        field.addShip(e);
//        field.addShip(f);
//        field.addShip(g);
//        field.addShip(h);
//        field.addShip(z);
//        field.addShip(k);

        drawPlayerField();
        drawEnemyField();

    }

    private void drawPlayerField() {
        int x = 40;
        int y = 40;
        for (int i = 0; i < field.getField().length; i++) {
            for (int j = 0; j < field.getField().length; j++) {
                if (field.getField()[i][j] == null) {
                    Rectangle rectangle = new Rectangle(y * j, x * i, 40, 40);
                    rectangle.setStroke(Color.BLACK);
                    rectangle.setFill(Color.AQUA);
                    pane.getChildren().add(rectangle);
                    final int X = j;
                    final int Y = i;
                    rectanglesField[i][j] = rectangle;
                    rectangle.setOnMouseClicked(event -> {
                        rectanglesField[Y][X].setFill(Color.GREY);
                        if (currentType == Ship.ShipType.Destroyer) {

                            rectanglesField[Y][X + 1].setFill(Color.GREY);
                        }
                    });
                } else {
                    Rectangle rectangle = new Rectangle(y * j, x * i, 40, 40);
                    rectangle.setStroke(Color.BLACK);
                    rectangle.setFill(Color.GREY);
                    pane.getChildren().add(rectangle);
                    rectanglesField[i][j] = rectangle;
                }
            }
        }
    }

    private void drawEnemyField() {
        int x = 40;
        int y = 40;
        for (int i = 0; i < field.getField().length; i++) {
            for (int j = 0; j < field.getField().length; j++) {
                Rectangle rectangle = new Rectangle(y * j + 440, x * i, 40, 40);
                rectangle.setStroke(Color.BLACK);
                rectangle.setFill(Color.AQUA);
                rectangle.setOnMouseClicked(event -> {
                    rectangle.setFill(Color.RED);
                });
                pane.getChildren().add(rectangle);
            }
        }
    }
}

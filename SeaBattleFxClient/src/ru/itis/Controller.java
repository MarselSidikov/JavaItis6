package ru.itis;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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

    @FXML
    private Rectangle cruiserRect;

    @FXML
    private Rectangle battleshipRect;

    @FXML
    private Label labelBattleshipCount;

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

        cruiserRect.setOnMouseClicked(event -> {
            currentType = Ship.ShipType.Cruiser;
        });

        battleshipRect.setOnMouseClicked(event -> {
            currentType = Ship.ShipType.Battleship;
        });

        field = new PlayingField();

        drawPlayerField();
        drawEnemyField();

    }

    // рисуем поле игрока
    private void drawPlayerField() {
        // начальные отступы
        int x = 40;
        int y = 40;
        // бежим по всем квардратам поля
        // по строкам
        for (int i = 0; i < field.getField().length; i++) {
            // по столбцам
            for (int j = 0; j < field.getField().length; j++) {
                // если корабля в той позиции нет
                if (field.getField()[i][j] == null) {
                    // создаем в указанной позиции голубой квадрат
                    Rectangle rectangle = new Rectangle(y * j, x * i, 40, 40);
                    // сделали каемку (C) Амир
                    rectangle.setStroke(Color.BLACK);
                    // закрасили квадрат
                    rectangle.setFill(Color.AQUA);
                    // засуну квадрат на форму
                    pane.getChildren().add(rectangle);
                    // запомнили координаты квадрата
                    final int X = j;
                    final int Y = i;
                    // положили квадрат в матрицу квадратов
                    rectanglesField[i][j] = rectangle;
                    // для текущего квадрата назначили событие при нажатии кнопкой мыши
                    rectangle.setOnMouseClicked(event -> {
                        if (event.getButton().toString().equals("PRIMARY")) {
                            if (currentType == Ship.ShipType.Boat) {
                                rectanglesField[Y][X].setFill(Color.GREY);
                            }
                            else if (currentType == Ship.ShipType.Destroyer) {
                                rectanglesField[Y][X].setFill(Color.GREY);
                                rectanglesField[Y][X + 1].setFill(Color.GREY);
                            } else if (currentType == Ship.ShipType.Cruiser) {
                                rectanglesField[Y][X].setFill(Color.GREY);
                                rectanglesField[Y][X + 1].setFill(Color.GREY);
                                rectanglesField[Y][X + 2].setFill(Color.GREY);
                            } else if (currentType == Ship.ShipType.Battleship) {
                                rectanglesField[Y][X].setFill(Color.GREY);
                                rectanglesField[Y][X + 1].setFill(Color.GREY);
                                rectanglesField[Y][X + 2].setFill(Color.GREY);
                                rectanglesField[Y][X + 3].setFill(Color.GREY);
                            }
                            field.addShip(new Ship(X, Y, true, currentType));
                        } else {
                            if (currentType == Ship.ShipType.Boat) {
                                rectanglesField[Y][X].setFill(Color.GREY);
                            }
                            else if (currentType == Ship.ShipType.Destroyer) {
                                rectanglesField[Y][X].setFill(Color.GREY);
                                rectanglesField[Y+1][X].setFill(Color.GREY);
                            } else if (currentType == Ship.ShipType.Cruiser) {
                                rectanglesField[Y][X].setFill(Color.GREY);
                                rectanglesField[Y+1][X].setFill(Color.GREY);
                                rectanglesField[Y+2][X].setFill(Color.GREY);
                            } else if (currentType == Ship.ShipType.Battleship) {
                                rectanglesField[Y][X].setFill(Color.GREY);
                                rectanglesField[Y+1][X].setFill(Color.GREY);
                                rectanglesField[Y+2][X].setFill(Color.GREY);
                                rectanglesField[Y+3][X].setFill(Color.GREY);
                            }
                            field.addShip(new Ship(X, Y, false, currentType));
                        }
                    });
                } else {
                    System.out.println("Fake");
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

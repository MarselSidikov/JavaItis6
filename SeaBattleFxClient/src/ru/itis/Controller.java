package ru.itis;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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

    @FXML
    private Label labelCruiserCount;

    @FXML
    private Label labelDestroyerCount;

    @FXML
    private Label labelBoatCount;

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
                    Rectangle rectangle = createRectangle(x, y, i, j);
                    // запомнили координаты квадрата
                    final int X = j;
                    final int Y = i;
                    // положили квадрат в матрицу квадратов
                    rectanglesField[i][j] = rectangle;
                    // для текущего квадрата назначили событие при нажатии кнопкой мыши
                    rectangle.setOnMouseClicked(event -> {
                        if (isCorrectPosition(X, Y, currentType.ordinal() + 1, isLeftButton(event))) {
                            switch (currentType) {
                                case Boat: {
                                    int currentBoatCount = Integer.parseInt(labelBoatCount.getText());
                                    if (isCorrectShipsCount(currentBoatCount)) {
                                        drawBoat(X, Y);
                                        currentBoatCount -= 1;
                                        labelBoatCount.setText(currentBoatCount + "");
                                    }
                                    break;
                                }
                                case Destroyer: {
                                    int currentDestroyerCount = Integer.parseInt(labelDestroyerCount.getText());
                                    if (isCorrectShipsCount(currentDestroyerCount)) {
                                        if (isLeftButton(event)) {
                                            drawDestroyerHorizontal(X, Y);
                                        } else {
                                            drawDestroyerVertical(X, Y);
                                        }
                                        currentDestroyerCount -= 1;
                                        labelDestroyerCount.setText(currentDestroyerCount + "");
                                    }
                                    break;
                                }
                                case Cruiser: {
                                    int currentCruiserCount = Integer.parseInt(labelCruiserCount.getText());
                                    if (isCorrectShipsCount(currentCruiserCount)) {
                                        if (isLeftButton(event)) {
                                            drawCruiserHorizontal(X, Y);
                                        } else {
                                            drawCruiserVertical(X, Y);
                                        }
                                        currentCruiserCount -= 1;
                                        labelCruiserCount.setText(currentCruiserCount + "");
                                    }
                                    break;
                                }
                                case Battleship: {
                                    int currentBattleshipCount = Integer.parseInt(labelBattleshipCount.getText());
                                    if (isCorrectShipsCount(currentBattleshipCount)) {
                                        if (isLeftButton(event)) {
                                            drawBattleshipHorizontal(X, Y);
                                        } else {
                                            drawBattleshipVertical(X, Y);
                                        }
                                        currentBattleshipCount -= 1;
                                        labelBattleshipCount.setText(currentBattleshipCount + "");
                                    }
                                    break;
                                }
                            }
                        }
                        //field.addShip(new Ship(X, Y, true, currentType));
                        //field.addShip(new Ship(X, Y, false, currentType));
                    });
                }
            }
        }
    }

    private boolean isCorrectPosition(int x, int y, int shipLength, boolean isHorizontal) {
        if (isHorizontal) {
            for (int i = y - 1; i < y + 2; i++) {
                for (int j = x - 1; j < x + shipLength + 1; j++) {
                    if (isCorrectFor(x, shipLength, i, j)) {
                        return false;
                    }
                }
            }
        } else {
            for (int i = y - 1; i < y + shipLength + 1; i++) {
                for (int j = x - 1; j < x + 2; j++) {
                    if (isCorrectFor(y, shipLength, i, j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean isCorrectFor(int position, int shipLength, int i, int j) {
        if (i < 10 && i >= 0 && j < 10 && j >= 0) {
            if (position + shipLength > 10) {
                return true;
            }
            if (!rectanglesField[i][j].getFill().toString().equals("0x00ffffff")) {
                return true;
            }
        }
        return false;
    }


    private Rectangle createRectangle(int x, int y, int i, int j) {
        // создаем в указанной позиции голубой квадрат
        Rectangle rectangle = new Rectangle(y * j, x * i, 40, 40);
        // сделали каемку (C) Амир
        rectangle.setStroke(Color.BLACK);
        // закрасили квадрат
        rectangle.setFill(Color.AQUA);
        // засуну квадрат на форму
        pane.getChildren().add(rectangle);
        return rectangle;
    }

    private boolean isLeftButton(MouseEvent event) {
        return event.getButton().toString().equals("PRIMARY");
    }

    private boolean isCorrectShipsCount(int currentBoatCount) {
        return currentBoatCount > 0;
    }

    private void drawBattleshipVertical(int x, int y) {
        rectanglesField[y][x].setFill(Color.GREY);
        rectanglesField[y + 1][x].setFill(Color.GREY);
        rectanglesField[y + 2][x].setFill(Color.GREY);
        rectanglesField[y + 3][x].setFill(Color.GREY);
    }

    private void drawBattleshipHorizontal(int x, int y) {
        rectanglesField[y][x].setFill(Color.GREY);
        rectanglesField[y][x + 1].setFill(Color.GREY);
        rectanglesField[y][x + 2].setFill(Color.GREY);
        rectanglesField[y][x + 3].setFill(Color.GREY);
    }

    private void drawBoat(int x, int y) {
        rectanglesField[y][x].setFill(Color.GREY);
    }

    private void drawDestroyerVertical(int x, int y) {
        rectanglesField[y][x].setFill(Color.GREY);
        rectanglesField[y + 1][x].setFill(Color.GREY);
    }

    private void drawDestroyerHorizontal(int x, int y) {
        rectanglesField[y][x].setFill(Color.GREY);
        rectanglesField[y][x + 1].setFill(Color.GREY);
    }

    private void drawCruiserVertical(int x, int y) {
        rectanglesField[y][x].setFill(Color.GREY);
        rectanglesField[y + 1][x].setFill(Color.GREY);
        rectanglesField[y + 2][x].setFill(Color.GREY);
    }

    private void drawCruiserHorizontal(int x, int y) {
        rectanglesField[y][x].setFill(Color.GREY);
        rectanglesField[y][x + 1].setFill(Color.GREY);
        rectanglesField[y][x + 2].setFill(Color.GREY);
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

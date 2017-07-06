package ru.itis;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.springframework.web.client.RestTemplate;
import ru.itis.game.Ship;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Controller {

    private int player = 1;
    private String host = "http://localhost:8080";

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

    private Rectangle rectanglesField[][];

    private Ship.ShipType currentType;

    private RestTemplate template;

    @FXML
    public void initialize() {
        template = new RestTemplate();

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

        drawEnemyField();
        drawPlayerField();

    }

    // рисуем поле игрока
    private void drawPlayerField() {
        // начальные отступы
        int x = 40;
        int y = 40;
        // бежим по всем квардратам поля
        // по строкам
        for (int i = 0; i < 10; i++) {
            // по столбцам
            for (int j = 0; j < 10; j++) {
                // если корабля в той позиции нет
                if (rectanglesField[i][j] == null) {
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

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Rectangle rectangle = new Rectangle(y * j + 440, x * i, 40, 40);
                rectangle.setStroke(Color.BLACK);
                rectangle.setFill(Color.AQUA);
                final int X = j;
                final int Y = i;
                rectangle.setOnMouseClicked((MouseEvent event) -> {
                    // игрок делает выстрел
                    template
                            .getForObject(host + "/battle/shot" +
                                    "?shotX=" + X + "&shotY=" + Y + "&player=" + player, Object.class);
                    // игрок получает информацию о статусе своего выстрела
                    String status = template.getForObject(host + "/battle/shot/status/info?player=" + player,
                            String.class);
                    if (status.equals("MISS")) {
                        rectangle.setFill(Color.CHOCOLATE);
                    } else {
                        rectangle.setFill(Color.RED);
                    }

                    waitShot();
                });
                pane.getChildren().add(rectangle);
            }
        }
        // ждем выстрел соперника
//        if (player == 2) {
//            waitShot();
//        }
    }

    private void waitShot() {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                System.out.println("wait");
                // теперь игрок ждет выстрела соперника
                String shot = template.
                        getForObject(host + "/battle/shot/info?player=" + player, String.class);
                String splitShot[] = shot.split(" ");
                int Xc = Integer.parseInt(splitShot[0]);
                int Yc = Integer.parseInt(splitShot[1]);
                rectanglesField[Yc][Xc].setFill(Color.RED);
                // игрок сообщает о статусе выстрела соперника
                String myStatus;
                System.out.println("waited");
                if (rectanglesField[Yc][Xc].getFill().toString().equals("0x00ffffff")) {
                    myStatus = "WOUND";
                } else {
                    myStatus = "MISS";
                }
                template.
                        getForObject(host + "/battle/shot/status?player=" + player + "&status=" + myStatus, String.class);
                return null;
            }
        };
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }
}

package ru.itis;

public class PlayingField {
    // список состояний выстрела - результат на выстрел
    public enum ShotState {
        MISS,
        KILL,
        WOUND
    }
    // константа - размер поля
    private final int FIELD_SIZE = 10;
    // массив лодок - само поле
    private Ship field[][] = new Ship[FIELD_SIZE][FIELD_SIZE];
    private int shots[][] = new int[FIELD_SIZE][FIELD_SIZE];

    // добавление лодки на поле
    public void addShip(Ship ship) {
        // проверяем корректность координат
        if (ship.getX()  < FIELD_SIZE &&
                ship.getX() >= 0 &&
                ship.getY() < FIELD_SIZE &&
                ship.getY() >= 0 &&
                (ship.isHorizontal() && (ship.getX() + ship.getNumberOfDecks() <= FIELD_SIZE)) ||
                (!ship.isHorizontal() && (ship.getY() + ship.getNumberOfDecks() <= FIELD_SIZE))) {
            // если горизонтальная ориентация лодки
            if (ship.isHorizontal()) {
                // заполняем массив слева направо
                for (int i = ship.getX(); i < ship.getX() + ship.getNumberOfDecks(); i++) {
                    field[ship.getY()][i] = ship;
                }
                // если ориентация вертикальная
            } else {
                // заполняем сверху вниз
                for (int j = ship.getY(); j < ship.getY() + ship.getNumberOfDecks(); j++) {
                    field[j][ship.getX()] = ship;
                }
            }
        }
    }

    // выстрел
    public ShotState shot(int x, int y) {
        x = x - 1;
        y = y - 1;
        shots[y][x] = 1;
        // если в месте выстрела ничего нет
        if (field[y][x] == null) {
            return ShotState.MISS;
        } else {
            // получаем лодку по координатам
            Ship ship = field[y][x];
            // уменьшаем количество палуб
            ship.shot();
            if (ship.getNumberOfDecks() == 0) {
                return ShotState.KILL;
            } else {
                return ShotState.WOUND;
            }
        }
    }

    public void showOnConsole() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (shots[i][j] == 1) {
                    System.out.print("* ");
                }
                else if (field[i][j] != null) {
                    System.out.print((field[i][j].getType().ordinal() + 1) + " ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

}

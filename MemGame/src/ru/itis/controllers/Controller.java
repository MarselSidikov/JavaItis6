package ru.itis.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// класс-контроллер, отвечает за логику игры
public class Controller {

    // константа - путь к мемам
    private static final String MEMES_FOLDER = "resources\\ru.itis\\memes";

    // путь к картинке с голубым фоном
    private static final String BACKGROUND_FILE = "resources\\ru.itis\\background.png";

    // путь к аудио-файлу
    private static final String AUDIO_FILE =
            "resources\\ru.itis\\beep.mp3";

    // файл с фоновой картинкой
    private static final File backgroundFile = new File(BACKGROUND_FILE);
    // полный корректный путь к файлу с картинкой
    private static final String background = backgroundFile.toURI().toString();

    // стиль панелек
    private static final String STYLE = "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0); " +
            "-fx-padding: 10; -fx-background-color: firebrick;" +
            " -fx-background-radius: 5;";

    // размер поля
    private static final int SIZE = 6;
    // количество необходимых мемов
    private static final int MEMES_COUNT = SIZE * SIZE / 2;
    // задержка при показе панелек
    private static final double DURATION = 0.7;

    // главная панель
    @FXML
    private AnchorPane pane;

    // массив, показывающий, какие случайные числа были сгенерированы
    // generatedNumber[5] = 1, значит число 5 было сгенерировано 1 раз
    private int generatedNumber[] = new int[MEMES_COUNT];

    // массив объектов ImageView - панельки
    private ImageView imageViews[][] = new ImageView[SIZE][SIZE];
    // массив картинок с мемасами
    private Image images[][] = new Image[SIZE][SIZE];

    // координаты последней нажатой панельки
    private int lastI = -1;
    private int lastJ = -1;

    // количество одновременно показанных мемасов
    private int countShows = 0;

    // матрица случайных чисел, которая соответствует распределению мемасов
    private int matrix[][] = new int[SIZE][SIZE];

    // происходит при загрузке приложения
    @FXML
    public void initialize() {
        // получаем доступ к папке с мемасами
        File memesFolder = new File(MEMES_FOLDER);
        // получаем массив файлов-мемасов
        File memes[] = memesFolder.listFiles();
        // список случайных чисел
        List<Integer> numbers = new ArrayList<>();
        // генератор случайных чисел
        Random random = new Random();
        // количество сгененированных чисел
        int count = 0;
        // пока не сгенерировали все числа
        while (count < SIZE * SIZE) {
            // получаем новое число
            int newValue = random.nextInt(MEMES_COUNT);
            // если данное число было сгенерировано менее двух раз
            if (generatedNumber[newValue] < 2) {
                // запоминаем число
                numbers.add(newValue);
                // увеличиваем количество встречаемости этого числа
                generatedNumber[newValue]++;
                // увеличиваем количество сгенерированных чисел
                count++;
            }
        }
        // загрузили звук и медиа-плейер
        Media sound = new Media(new File(AUDIO_FILE).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        int index = 0;
        // бежим по всей матрице
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // получаем файл с мемасом
                String fileName = memes[numbers.get(index)].toURI().toString();
                // положили случайное число в матрицу
                matrix[i][j] = numbers.get(index);
                // создали IMage с мемасом
                Image image = new Image(fileName);
                // положили в матрицу мемесов
                images[i][j] = image;
                // создали панельку для мема
                ImageView imageView = new ImageView(image);

                // настроили отображение
                imageView.setPreserveRatio(false);
                imageView.setStyle(STYLE);
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);
                imageView.setX(100 * j);
                imageView.setY(100 * i);
                // добавили на основную панель
                pane.getChildren().addAll(imageView);
                // перешли к следующему случайному числу
                index++;
                // запомнили панельку в матрице
                imageViews[i][j] = imageView;
                int finalJ = j;
                int finalI = i;

                // при нажатии на панельку
                imageViews[i][j].setOnMouseClicked(event -> {
                    // если одновременно показано менее 2-х картинок
                    if (countShows < 2) {
                        // воспроизводим звук
                        mediaPlayer.play();
                        // ставим плеер на начало
                        mediaPlayer.seek(new Duration(0));
                        // показываем картинку
                        imageViews[finalI][finalJ].setImage(images[finalI][finalJ]);
                        // если еще не была нажата ни одна картинка
                        if (lastI == -1 && lastJ == -1) {
                            // запоминаем ее координаты
                            lastI = finalI;
                            lastJ = finalJ;
                        } else {
                            // если картинка была нажата уже
                            // сравниваем случайные числа стоящие в матрице на этих позициях
                            if (matrix[finalI][finalJ] == matrix[lastI][lastJ] && (finalI != lastI ^ finalJ != lastJ)){
                                // запускаем таймер и удаляем
                                Timeline timeline = new Timeline();
                                timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(DURATION), timeEvent -> {
                                    imageViews[finalI][finalJ].setVisible(false);
                                    imageViews[lastI][lastJ].setVisible(false);
                                    lastI = -1;
                                    lastJ = -1;
                                    countShows = 0;
                                }));
                                timeline.play();
                            } else {
                                // если не правильно скрываем
                                Timeline timeline = new Timeline();
                                timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1.3), timeEvent -> {
                                    imageViews[finalI][finalJ].setImage(new Image(background));
                                    imageViews[lastI][lastJ].setImage(new Image(background));
                                    lastI = -1;
                                    lastJ = -1;
                                    countShows = 0;
                                }));
                                timeline.play();
                            }
                        }
                        countShows++;
                    }
                });
            }
        }
    }

    public void hide() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                imageViews[i][j].setImage(new Image(background));
            }
        }
    }

}
package sample;

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

public class Controller {

    private static final String MEMES_FOLDER = "resources\\ru.itis\\memes";

    private static final String BACKGROUND_FILE = "resources\\ru.itis\\background.png";

    private static final String AUDIO_FILE =
            "resources\\ru.itis\\beep.mp3";

    private static final String STYLE = "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0); " +
            "-fx-padding: 10; -fx-background-color: firebrick;" +
            " -fx-background-radius: 5;";

    @FXML
    private AnchorPane pane;

    private int generatedNumber[] = new int[32];

    private ImageView imageViews[][] = new ImageView[8][8];
    private Image images[][] = new Image[8][8];

    private int lastI = -1;
    private int lastJ = -1;

    private int matrix[][] = new int[8][8];

    @FXML
    public void initialize() {
        File memesFolder = new File(MEMES_FOLDER);
        File memes[] = memesFolder.listFiles();
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        int count = 0;
        // пока не сгенерировали 64 числа
        while (count < 64) {
            // получаем новое число
            int newValue = random.nextInt(32);
            // если данное число было сгенерировано менее двух раз
            if (generatedNumber[newValue] < 2) {
                // запоминаем число
                numbers.add(newValue);
                // увеличиваем количествто встречаемости этого числа
                generatedNumber[newValue]++;
                // увеличиваем количество сгенерированных чисел
                count++;
            }
        }

        int index = 0;
        File backgroundFile = new File(BACKGROUND_FILE);
        String background = backgroundFile.toURI().toString();
        Media sound = new Media(new File(AUDIO_FILE).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String fileName = memes[numbers.get(index)].toURI().toString();
                matrix[i][j] = numbers.get(index);
                Image image = new Image(fileName);
                images[i][j] = image;
                ImageView imageView = new ImageView(image);

                imageView.setPreserveRatio(false);
                imageView.setStyle(STYLE);
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);
                imageView.setX(100 * j);
                imageView.setY(100 * i);
                pane.getChildren().addAll(imageView);
                index++;
                imageViews[i][j] = imageView;
                int finalJ = j;
                int finalI = i;
                imageViews[i][j].setOnMouseClicked(event -> {
                    mediaPlayer.play();
                    mediaPlayer.seek(new Duration(0));
                    imageViews[finalI][finalJ].setImage(images[finalI][finalJ]);
                    if (lastI == -1 && lastJ == -1) {
                        lastI = finalI;
                        lastJ = finalJ;
                    } else {
                        if (matrix[finalI][finalJ] == matrix[lastI][lastJ]) {
                            Timeline timeline = new Timeline();
                            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1.3), timeEvent -> {
                                imageViews[finalI][finalJ].setVisible(false);
                                imageViews[lastI][lastJ].setVisible(false);
                                lastI = -1;
                                lastJ = -1;
                            }));
                            timeline.play();
                        } else {
                            Timeline timeline = new Timeline();
                            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1.3), timeEvent -> {
                                imageViews[finalI][finalJ].setImage(new Image(background));
                                imageViews[lastI][lastJ].setImage(new Image(background));
                                lastI = -1;
                                lastJ = -1;
                            }));
                            timeline.play();
                        }
                    }
                });
            }
        }
        int i = 0;
    }

    public void hide() {
        File backgroundFile = new File(BACKGROUND_FILE);
        String background = backgroundFile.toURI().toString();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                imageViews[i][j].setImage(new Image(background));
            }
        }
    }

}
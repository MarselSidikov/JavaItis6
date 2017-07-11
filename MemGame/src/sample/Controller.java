package sample;

import javafx.fxml.FXML;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {

    private static final String MEMES_FOLDER = "C:\\Users" +
            "\\admin.WIN-IPM3OA3VQNQ\\Desktop\\JAVA_REPO\\JavaItis6\\MemGame\\memes";

    private static final String BACKGROUND_FOLDER = "C:\\Users\\admin.WIN-IPM3OA3VQNQ\\Desktop\\JAVA_REPO" +
            "\\JavaItis6\\MemGame\\background.png";

    private static final String STYLE = "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0); " +
            "-fx-padding: 10; -fx-background-color: firebrick;" +
            " -fx-background-radius: 5;";

    @FXML
    private AnchorPane pane;

    private int generatedNumber[] = new int[32];

    private ImageView imageViews[][] = new ImageView[8][8];

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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String fileName = memes[numbers.get(index)].toURI().toString();
                ImageView image = new ImageView(fileName);
                image.setPreserveRatio(false);
                image.setStyle(STYLE);
                image.setFitWidth(100);
                image.setFitHeight(100);
                image.setX(100 * j);
                image.setY(100 * i);
                pane.getChildren().addAll(image);
                index++;
                imageViews[i][j] = image;
                imageViews[i][j].setOnMouseClicked(event -> {

                });
            }
        }
    }

    public void hide() {
        File backgroundFile = new File(BACKGROUND_FOLDER);
        String background = backgroundFile.toURI().toString();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                imageViews[i][j].setImage(new Image(background));
            }
        }
    }

}
package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {

    @FXML
    private AnchorPane pane;

    private int generatedNumber[] = new int[32];

    @FXML
    public void initialize() {
        File memesFolder = new File("C:\\Users" +
                "\\admin.WIN-IPM3OA3VQNQ\\Desktop\\JAVA_REPO\\JavaItis6\\MemGame\\memes");
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
                image.setFitWidth(100);
                image.setFitHeight(100);
                image.setX(100 * j);
                image.setY(100 * i);
                pane.getChildren().addAll(image);
                index++;
            }
        }

    }

}
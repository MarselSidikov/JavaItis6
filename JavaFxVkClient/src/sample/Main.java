package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // преобразование файла sample.fxml в java-объект
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("VkClient");
        // задаем размер
        primaryStage.setScene(new Scene(root, 600, 400));
        // показываем сцену
        primaryStage.show();
    }


    public static void main(String[] args) {
        // запуск приложения
        launch(args);
    }
}

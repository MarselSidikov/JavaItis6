package ru.itis.app;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import ru.itis.controllers.Controller;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = (Parent)loader.load();
        primaryStage.setTitle("MEMES");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        Controller controller = loader.getController();

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(5), event -> controller.hide()));
        timeline.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

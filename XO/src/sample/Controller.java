package sample;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {

    @FXML
    private AnchorPane pane;

    private void drawRectangle(int x, int y){
        Rectangle rectangle = new Rectangle(x,y,40,40);
        rectangle.setStroke(Color.GRAY);
        rectangle.setFill(Color.WHITE);
        pane.getChildren().add(rectangle);
    }

    @FXML
    public void initialize() {
        pane.setOnMouseClicked(event -> {
            drawRectangle((int)event.getX(), (int)event.getY());
        });
    }
}

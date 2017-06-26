package ru.itis;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Button buttonHello;

    @FXML
    private Label labelHello;

    @FXML
    public void initialize() {
        buttonHello.setOnAction(event -> {
            labelHello.setText("HELLO!");
        });
    }
}

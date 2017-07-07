package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import ru.itis.vk.VkApiRestTemplate;
import ru.itis.vk.models.Friend;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    // создаем экземпляр класса для работы с API контакта (наша библиотека)
    VkApiRestTemplate template = new VkApiRestTemplate();

    // основная панель приложения
    @FXML
    AnchorPane pane;

    // кнопка для получения друзей
    @FXML
    Button buttonGetFriends;

    // текстовое поле, содержащее информацию об id-пользователя
    @FXML
    TextField textFieldUserId;

    // текстовое поле, содержащее информацию о необходимом количестве друзей
    @FXML
    TextField textFieldCount;

    // список панелек для друзей
    private List<TitledPane> friendPanes = new ArrayList<>();

    // список идентификаторов
    private List<Integer> ids = new ArrayList<>();

    // метод выполняется когда приложение только начало запуск
    @FXML
    public void initialize() {
        // назначаем кнопке событие при нажатии
        buttonGetFriends.setOnAction(event -> {
            getFriends();

        });
    }

    private void getFriends() {
        // получили id пользователя, сделали числом
        int userId = Integer.parseInt(textFieldUserId.getText());
        // получили количество друзей, сделали числом
        int count = Integer.parseInt(textFieldCount.getText());
        // получили всех друзей через интернеты
        List<Friend> friends = template.getUserFriends(userId, count);
        // контейнер панелек
        VBox vBox = new VBox();
        // прокручиваемая панель
        ScrollPane scrollPane = new ScrollPane();
        int currentFriendNumber = 0;
        // пробегаем по всем друзьям
        for (Friend friend : friends) {
            ids.add(friend.getId());
            // для конкретного друга
            // создали ImageView и засунули фотку
            ImageView imageView = new ImageView();
            int finalCurrentFriendNumber = currentFriendNumber;
            imageView.setOnMouseClicked(event -> {
                        getFriends();
            });
            // сделали titledPane - заголовок + содержимое
            // заголовок - имя, содержимое - фотография
            TitledPane friendPane = new TitledPane(friend.getFirstName() + " "
                    + " " + friend.getLastName(), imageView);
            // говорим, что изначально будет свернуто
            friendPane.setExpanded(false);
            // привязываем событие
            friendPane.setOnMouseClicked(event -> {
                imageView.setImage(new Image(friend.getPhoto()));
            });
            // добавили панель в список всех панелей
            friendPanes.add(friendPane);
            // добавили панель в коробку
            vBox.getChildren().add(friendPane);
            currentFriendNumber++;
        }
        // настроили scroll
        scrollPane.setContent(vBox);
        // максимальная высота
        scrollPane.setPrefHeight(500);
        scrollPane.setFitToWidth(false);
        // добавили scroll на основную панель
        pane.getChildren().add(scrollPane);
    }

}
package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import ru.itis.vk.VkApiRestTemplate;
import ru.itis.vk.models.Friend;

import java.util.ArrayList;
import java.util.List;

public class Controller {
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

    // метод выполняется когда приложение только начало запуск
    @FXML
    public void initialize() {
        // создаем экземпляр класса для работы с API контакта (наша библиотека)
        VkApiRestTemplate template = new VkApiRestTemplate();
        // назначаем кнопке событие при нажатии
        buttonGetFriends.setOnAction(event -> {
            // получили id пользователя, сделали числом
            int userId = Integer.parseInt(textFieldUserId.getText());
            // получили количество друзей, сделали числом
            int count = Integer.parseInt(textFieldCount.getText());
            // получили всех друзей через интернеты
            List<Friend> friends = template.getUserFriends(userId, count);
            // отступ для панельки
            double lastY = 0;
            // контейнер панелек
            VBox vBox = new VBox();
            // прокручиваемая панель
            ScrollPane scrollPane = new ScrollPane();
            // пробегаем по всем друзьям
            for (Friend friend : friends) {
                // для конкретного друга
                // создали ImageView и засунули фотку
                ImageView imageView = new ImageView(friend.getPhoto());
                // сделали titledPane - заголовок + содержимое
                // заголовок - имя, содержимое - фотография
                TitledPane friendPane = new TitledPane(friend.getFirstName() + " "
                        + " " + friend.getLastName(), imageView);
                // задаем отступ
                friendPane.setLayoutY(lastY);
                // говорим, что изначально будет свернуто
                friendPane.setExpanded(false);
                // посчитали новый отступ исходя из размеров предыдущей картинки
                lastY = lastY + imageView.getImage().getHeight();
                // добавили панель в список всех панелей
                friendPanes.add(friendPane);
                // добавили панель в коробку
                vBox.getChildren().add(friendPane);

            }
            // настроили scroll
            scrollPane.setContent(vBox);
            // максимальная высота
            scrollPane.setPrefHeight(500);
            scrollPane.setFitToWidth(false);
            // добавили scroll на основную панель
            pane.getChildren().add(scrollPane);
        });
    }

}
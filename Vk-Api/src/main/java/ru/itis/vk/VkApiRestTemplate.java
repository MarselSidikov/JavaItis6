package ru.itis.vk;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.itis.vk.models.Friend;
import ru.itis.vk.models.Friends;

import java.util.Arrays;
import java.util.List;

public class VkApiRestTemplate {
    // URL, на который отправляем запрос для получения друзей
    private final String FRIENDS_GET_URL = "https://api.vk.com/api.php?oauth=1&method=friends.get";

    // инструмент, позволяющий посылать запросы в интернет
    private RestTemplate template;

    public VkApiRestTemplate() {
        this.template = new RestTemplate();
    }

    /**
     * Получает список друзей пользователя
     * @param userId идентифкатор пользователя, друзей которого мы хотим получить
     * @param count количество получаемых друзей
     * @return список друзей
     */
    public List<Friend> getUserFriends(int userId, int count) {
        // создаем строку запроса с параметрами
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(FRIENDS_GET_URL)
                .queryParam("user_id", userId)
                .queryParam("count", count)
                .queryParam("fields", "photo_200_orig");

        // создаем строку расширенного URL-запроса
        String expandUrl = builder.toUriString();
        System.out.println(expandUrl);
        // отправляем get-запрос на указанный URL
        // получаем JSON-объекты
        // они автоматически конвертируются в объекты
        // класса Friends
        Friends response = template.getForObject(expandUrl, Friends.class);
        return response.getResponse();
    }
}

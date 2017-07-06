package ru.itis.vk;

import ru.itis.vk.models.Friend;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        VkApiRestTemplate template = new VkApiRestTemplate();
        List<Friend> friends = template.getUserFriends(176050764, 15);
        for (Friend friend : friends) {
            System.out.println(friend.getFirstName() + " "
            + friend.getLastName() + " " + friend.getPhoto());
        }
    }
}

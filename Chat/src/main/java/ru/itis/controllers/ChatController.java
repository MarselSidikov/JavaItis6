package ru.itis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.models.Message;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChatController {

    private List<Message> messages = new ArrayList<>();

    private boolean hasNew = false;

    @PostMapping("/messages")
    public void postMessage(@RequestBody Message message) {
        messages.add(message);
        hasNew = true;
    }

    @GetMapping("/messages")
    public List<Message> getMessages() {
        while (true) {
            if (hasNew) {
                hasNew = false;
                return messages;
            }
        }
    }

}

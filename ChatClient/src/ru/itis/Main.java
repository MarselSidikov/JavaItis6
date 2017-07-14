package ru.itis;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // описываем второй поток
        Runnable runnable = () -> {
            RestTemplate template = new RestTemplate();
            while (true) {
                ResponseEntity<Message[]> response = template.getForEntity("http://10.17.1.53:8080/messages",
                        Message[].class);
                Message[] messages = response.getBody();
                ConsoleUtils.clearConsole();
                for (int i = 0; i < messages.length; i++) {
                    ConsoleUtils.print(messages[i].getText(), "Red");
                }
                ConsoleUtils.print("","White");
            }
        };

        new Thread(runnable).start();
        Scanner scanner = new Scanner(System.in);
        while (true){
            RestTemplate template = new RestTemplate();
            String message = scanner.nextLine();
            Message clientMessage = new Message(message);
            template.postForLocation("http://localhost:8080/messages", clientMessage);
        }




    }
}

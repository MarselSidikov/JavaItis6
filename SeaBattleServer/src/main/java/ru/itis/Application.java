package ru.itis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ru.itis")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}

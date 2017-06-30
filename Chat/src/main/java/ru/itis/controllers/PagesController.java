package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.itis.models.Student;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;

@Controller
public class PagesController {

    @GetMapping("/index")
    public String index(@ModelAttribute("model")ModelMap model) throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader("data\\students.txt"));
        String currentLine = reader.readLine();
        while (currentLine != null) {
            String data[] = currentLine.split(" ");
            Student student = new Student(
                    data[0],
                    Integer.parseInt(data[1]),
                    data[2]
            );
            students.add(student);
            currentLine = reader.readLine();
        }
        model.addAttribute("students", students);
        return "index";
    }
}

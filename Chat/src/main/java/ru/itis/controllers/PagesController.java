package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PagesController {

    @GetMapping("/index")
    public String index(@ModelAttribute("model") ModelMap model) throws Exception {
        List<Student> students = getStudents();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/students/add")
    public String addStudent(@ModelAttribute("model") ModelMap model, @RequestParam("name") String name,
                             @RequestParam("age") int age,
                             @RequestParam("category") String category) throws Exception {
        Student student = new Student(name, age, category);
        BufferedWriter writer = new BufferedWriter(
                new FileWriter("data\\students.txt", true));
        writer.write("\n" + student.getName() + " " + student.getAge() + " " + student.getCategory());
        writer.close();

        List<Student> students = getStudents();
        model.addAttribute("students", students);
        return "index";
    }

    private List<Student> getStudents() throws Exception {
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
        return students;
    }
}

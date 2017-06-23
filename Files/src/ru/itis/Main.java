package ru.itis;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("input.txt"));

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String parsedLine[] = line.split(" ");
            int age = Integer.parseInt(parsedLine[1]);
            System.out.println(line);
        }
    }
}

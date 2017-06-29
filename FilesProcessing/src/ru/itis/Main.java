package ru.itis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
       WordFinder finder = new WordFinder("hello", "files");
       ArrayList<String> dictionary = finder.createDictionary();
       for (String word : dictionary) {
           System.out.println(word);
       }
    }
}

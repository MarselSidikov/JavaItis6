package ru.itis;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class WordFinder extends Thread {

    private String word;
    private String folderName;

    public WordFinder(String word, String folderName) {
        this.word = word;
        this.folderName = folderName;
    }

    public ArrayList<String> createDictionary() throws Exception {
        HashSet<String> result = new HashSet<>();
        File folder = new File(folderName);
        if (folder.isDirectory()) {
            File files[] = folder.listFiles();
            for (int i = 0; i < files.length; i++) {
                ArrayList<String> words = getWords(files[i]);
                result.addAll(words);
            }
        }
        ArrayList<String> dictionary = new ArrayList<>(result);
        Collections.sort(dictionary);
        return dictionary;
    }

    private ArrayList<String> getWords(File file) throws Exception {
        // открыли поток для чтения из файла
        FileInputStream fileInputStream = new FileInputStream(file);
        // создали массив байтов согласно размеру файла
        byte[] data = new byte[(int) file.length()];
        // считаи все байты из файла в массив байтов data
        fileInputStream.read(data);
        // закрыли поток
        fileInputStream.close();
        // преобразовали все байты в строку с кодировкой Unicode
        String text = new String(data, "UTF-8");

        int count = 0;
        // разбили текст по пробелам
        String words[] = text.split(" ");

        ArrayList<String> wordsList = new ArrayList<>();
        // убрать лишние символы из каждой строки
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^А-яа-я]+", "");
            // кидаем в список слова
            if (words[i].length() != 0) {
                wordsList.add(words[i]);
            }
        }

        return wordsList;
    }
    private void findCountOfWordInFolder() throws Exception {
        File folder = new File(folderName);
        if (folder.isDirectory()) {
            File files[] = folder.listFiles();
            for (int i = 0; i < files.length; i++) {
                int count = findCountOfWordInFile(word, files[i]);
                System.out.println("Слово: " + word + " встречается в файле " + files[i].getName() + " " + count +" раз");
            }
        }
    }

    private int findCountOfWordInFile(String word, File file) throws Exception {
        // открыли поток для чтения из файла
        FileInputStream fileInputStream = new FileInputStream(file);
        // создали массив байтов согласно размеру файла
        byte[] data = new byte[(int) file.length()];
        // считаи все байты из файла в массив байтов data
        fileInputStream.read(data);
        // закрыли поток
        fileInputStream.close();
        // преобразовали все байты в строку с кодировкой Unicode
        String text = new String(data, "UTF-8");

        int count = 0;
        // разбили текст по пробелам
        String words[] = text.split(" ");

        ArrayList<String> wordsList = new ArrayList<>();
        // убрать лишние символы из каждой строки
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^А-яа-я]+", "");
            // кидаем в список слова
            if (words[i].length() != 0) {
                wordsList.add(words[i]);
            }
        }

        for (int i = 0; i < wordsList.size(); i++) {
            if (wordsList.get(i).toLowerCase().startsWith(word)) {
                count++;
            }
        }

        return count;
    }

    public void run() {
        try {
            findCountOfWordInFolder();
        } catch (Exception e) {
            System.err.println("Ошибка");
        }
    }
}

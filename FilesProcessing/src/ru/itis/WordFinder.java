package ru.itis;

import java.io.File;
import java.io.FileInputStream;

public class WordFinder {
    public void findCountOfWordInFolder(String word, String folderName) throws Exception {
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

        for (int i = 0; i < words.length; i++) {
            if (words[i].toLowerCase().startsWith(word)) {
                count++;
            }
        }

        return count;
    }
}

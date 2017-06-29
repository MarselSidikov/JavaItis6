package ru.itis;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class TextProcessor extends Thread {

    // поле - название папки с файлами
    private String folderName;

    // конструктор
    public TextProcessor(String folderName) {
        this.folderName = folderName;
    }

    public double getSimilarity(String a, String b) throws Exception {
        // построили словарь по всем документам
        ArrayList<String> dictionary = createDictionary();
        // получили слова из первого документа
        ArrayList<String> words1 = getWords(new File(a));
        // построили вектор для первого документа
        int[] vector1 = createVector(words1, dictionary);

        // получили слова из второго документа
        ArrayList<String> words2 = getWords(new File(b));
        // получили вектор для второго документа
        int[] vector2 = createVector(words2, dictionary);

        double similarity = 0;

        int n = dictionary.size();

        int numerator = 0;

        for (int i = 0; i < n; i++) {
            numerator = numerator + vector1[i] * vector2[i];
        }

        int aSum = 0;

        for (int i = 0; i < n; i++) {
            aSum = aSum + vector1[i] * vector1[i];
        }

        int bSum = 0;

        for (int i = 0; i < n; i++) {
            bSum = bSum + vector2[i] * vector2[i];
        }

        double aSqrt = Math.sqrt(aSum);
        double bSqrt = Math.sqrt(bSum);

        similarity = numerator / (aSqrt * bSqrt);

        return similarity;
    }

    // функция строит вектор для файла со словами words и словаря dictionary
    // Вектор:
    // слово_из_словаря - частота встречаемости в документе
    public int[] createVector(List<String> words, ArrayList<String> dictionary) {
        // создаем массив для вектора - его размер - это размер словаря
        int[] vector = new int[dictionary.size()];
        // пробегаем по всем словам из словаря
        for (int i = 0; i < dictionary.size(); i++) {
            // пробегаем для каждого слова из словаря
            // все слова из текста
            for (int j = 0; j < words.size(); j++) {
                // если встретили такое слово
                if (dictionary.get(i).equals(words.get(j))) {
                    // значение вектора увеличиваем на 1
                    vector[i] = vector[i] + 1;
                }
            }
        }
        // возвращаем результат
        return vector;
    }

    // создание словаря - список всех слов из всех файлов
    // упорядоченный по алфавиту
    public ArrayList<String> createDictionary() throws Exception {
        // создаем множество - в множестве элементы
        // не повторяются
        // по сути список с уникальными элементами
        HashSet<String> result = new HashSet<>();
        // получили список незначимых слов
        ArrayList<String> stopwords = getWords(new File("stopwords\\stopwords.txt"));
        // получили папку с документами
        File folder = new File(folderName);
        // если это действительно папка
        if (folder.isDirectory()) {
            // получаем список файлов
            File files[] = folder.listFiles();
            // для каждого файла
            for (int i = 0; i < files.length; i++) {
                // получаем список всех слов из файла
                ArrayList<String> words = getWords(files[i]);
                // удаляем из списка все незначимые слова
                words.removeAll(stopwords);
                // добавляем список во множество
                // таким образом все повторяющиеся элементы будут удалены
                result.addAll(words);
            }
        }
        // преобразуем множество в обычный список
        ArrayList<String> dictionary = new ArrayList<>(result);
        // сортируем все слова
        Collections.sort(dictionary);
        // возвращаем результат
        return dictionary;
    }

    // получение списка слов из файла
    public ArrayList<String> getWords(File file) throws Exception {
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
        // разбили текст по пробелам и прочим символам
        String words[] = text.split("[ \\t\\n\\x0B\\f\\r-]");
        // создали список для всех слов
        ArrayList<String> wordsList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            // убрать лишние символы из каждого слова
            words[i] = words[i].replaceAll("[^А-Яа-я]+", "");
            // кидаем в список слова
            if (words[i].length() != 0) {
                wordsList.add(words[i]);
            }
        }

        return wordsList;
    }
}

package ru.itis;

// https://ru.wikipedia.org/wiki/%D0%92%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%BD%D0%B0%D1%8F_%D0%BC%D0%BE%D0%B4%D0%B5%D0%BB%D1%8C

public class Main {

    public static void main(String[] args) throws Exception {
        TextProcessor finder = new TextProcessor("papers");
        double similarity = finder.getSimilarity("papers\\scats.txt", "papers\\sharks.txt");
        System.out.println(similarity);
    }
}

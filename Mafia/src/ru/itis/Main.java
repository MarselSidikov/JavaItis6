package ru.itis;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    String names[] = {
	            "Аделя",
                "Сергей",
                "Катя",
                "Адель",
                "Амир",
                "Леонид",
                "Вася",
                "Даниил",
                "Святослав"};

	    String roles[] = {
	            "Мафия",
                "Мафия",
                "Комиссар",
                "Доктор",
                "Житель",
                "Житель",
                "Житель",
                "Житель",
                "Житель"};

	    boolean generatedRoles[] = new boolean[9];

        Random random = new Random();
        for (int i = 0; i < names.length; i++) {
            int role = random.nextInt(9);
            while (generatedRoles[role]) {
                role = random.nextInt(9);
            }
            generatedRoles[role] = true;
            System.out.println(names[i] + " " + roles[role]);
        }
    }
}

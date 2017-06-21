package ru.itis;

import java.util.Scanner;

/**
 * Created by admin on 21.06.2017.
 */
public class CalcerWithoutArray {
    int getR(int n) {
        Scanner scanner = new Scanner(System.in);
        int maxEven = -1;
        int maxOdd = -1;
        boolean hasMaxEven = false;
        boolean hasMaxOdd = false;
        int i = 0;
        while (i < n) {
            int currentNumber = scanner.nextInt();
            if (currentNumber % 2 == 0 && currentNumber > maxEven) {
                maxEven = currentNumber;
                hasMaxEven = true;
            } else if (currentNumber % 2 == 1 && currentNumber > maxOdd) {
                maxOdd = currentNumber;
                hasMaxOdd = true;
            }
            i++;
        }
        if (hasMaxEven && hasMaxOdd) {
            return maxEven + maxOdd;
        }
        return -1;
    }
}

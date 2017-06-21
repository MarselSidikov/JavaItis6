package ru.itis;

import java.util.Scanner;

public class Calcer {
    int a[];
    int N;

    public Calcer() {
        a = new int[15];
    }

    public void readNumbers(int n) {
        Scanner scanner = new Scanner(System.in);
        N = n;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
    }

    public int calcR() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (a[j] + a[i] > sum) {
                    sum = a[j] + a[i];
                }
            }
        }
        return sum;
    }
}

package ru.itis;

public class MainMarks {
    /**
     * Подпрограмма-процедура, сортирующая массив пузырьком
     * @param a - сортируемый массив, формальный параметр, сюда будет передан конкретный массив
     */
    public static void bubbleSort(int a[]) {
        for (int i = a.length -1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int minIndex = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                }
            }
            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    public static void showMatrix(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // оценки студента
        int marks[][] = {
                {5, 5, 2, 5, 1},
                {3, 2, 2, 1, 5},
                {1, 2, 2, 5, 4},
                {4, 4, 3, 5, 5},
                {3, 4, 5, 4, 5},
                {1, 5, 1, 4, 3}};

        for (int i = 0; i < marks.length; i++) {
            // вызов процедуры, marks[i] - аргумент
            insertionSort(marks[i]);
        }
        // marks - аргумент
        showMatrix(marks);
    }
}

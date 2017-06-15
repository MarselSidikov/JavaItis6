package ru.itis;

public class MinMaxSwap {

    /**
     * Функция, возвращающая индекс минимального элемента
     * @param a - массив, в котором ищем минимальный элемент
     * @return индекс минимального значения в массиве
     */
    public static int minElementIndex(int a[]) {
        int minIndex = 0;
        int min = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static int maxElementIndex(int a[]) {
        int maxIndex = 0;
        int max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static void minMaxSwap(int a[]) {
        int maxIndex = maxElementIndex(a);
        int minIndex = minElementIndex(a);
        int temp = a[maxIndex];
        a[maxIndex] = a[minIndex];
        a[minIndex] = temp;
    }
    public static void main(String[] args) {
        int array[] = {2, 3, -1, 5, 1, 0};
        minMaxSwap(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

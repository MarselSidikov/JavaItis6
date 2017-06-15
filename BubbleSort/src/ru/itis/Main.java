package ru.itis;

public class Main {

    // psvm - public static void Main
    // sout - Sytem.out.println()
    public static void main(String[] args) {
        // явная инициализация
	    int a[] = {4, -2, 5, 2, 11, 9};

	    for (int i = a.length -1; i >= 0; i--) {
	        for (int j = 0; j < i; j++) {
	            if (a[j] > a[j+1]) {
	                int temp = a[j];
	                a[j] = a[j+1];
	                a[j+1] = temp;
                }
                for (int k = 0; k < a.length; k++) {
                    System.out.print(a[k] + " ");
                }

            }
        }
    }
}

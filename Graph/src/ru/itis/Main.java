package ru.itis;

public class Main {

    public static void addEdge(int matrix[][], int i, int j) {
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }
    public static void main(String[] args) {
        /*
        0 1 2 3 4
       0
       1
       2
       3
       4
         */
	    int matrix[][] = new int[5][5];
	    addEdge(matrix, 2, 3);
    }
}

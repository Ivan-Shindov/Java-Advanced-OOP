package exercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[n][n];
        int startNum = 1;

        if (pattern.equals("A")) {
            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = startNum++;
                }
            }
        } else if (pattern.equals("B")) {
            for (int col = 0; col < n; col++) {
                if (col % 2 == 0) {
                    for (int row = 0; row < n; row++) {
                        matrix[row][col] = startNum++;
                    }
                } else {
                    for (int row = n - 1; row >= 0; row--) {
                        matrix[row][col] = startNum++;
                    }
                }
            }
        }

        printMatrix(matrix,n,n);
    }

    private static void printMatrix(int[][] matrix, int n, int n1) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n1; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
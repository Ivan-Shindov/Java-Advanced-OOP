package exercise;

import java.util.*;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }

        StringBuilder output = new StringBuilder();

        int currentRow = matrix.length - 1;
        int currentCol = matrix[currentRow].length - 1;

        while (currentCol >= 0) {
            output.append(matrix[currentRow][currentCol]).append(" ");

            int upperRow = currentRow - 1;
            int upperAndRightCol = currentCol + 1;
            while (upperRow >= 0 && upperAndRightCol < matrix[upperRow].length) {
                output.append(matrix[upperRow][upperAndRightCol]).append(" ");
                upperRow--;
                upperAndRightCol++;
            }

            currentCol--;
            output.append("\n");

        }
        currentCol = 0;
        currentRow -= 1;

        while (currentRow >= 0) {
            output.append(matrix[currentRow][currentCol]).append(" ");

            int upperRow = currentRow - 1;
            int upperAndRightCol = currentCol + 1;
            while (upperRow >= 0 && upperAndRightCol < matrix[upperRow].length) {
                output.append(matrix[upperRow][upperAndRightCol]).append(" ");
                upperRow--;
                upperAndRightCol++;
            }

            currentRow--;
            output.append("\n");

        }

        System.out.println(output);

    }
}

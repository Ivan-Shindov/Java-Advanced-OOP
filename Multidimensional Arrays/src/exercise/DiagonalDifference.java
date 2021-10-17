package exercise;

import java.util.*;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int primarySum = calcPrimarySum(matrix);
        int secondarySum = calcSeocndarySum(matrix);
        System.out.println(Math.abs(primarySum - secondarySum));

    }

    private static int calcSeocndarySum(int[][] matrix) {
        int sum = 0;

        int row = 0 , col = matrix.length - 1;

        while (col >= 0) {
            sum += matrix[row][col];
            row++;
            col--;
        }

        return sum;
    }

    private static int calcPrimarySum(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }
}
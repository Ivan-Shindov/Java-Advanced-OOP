package lab;

import java.util.*;

public class MaximumSum2x2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = readArray(scanner,", ");
        int rows = size[0];
        int cols = size[1];

        int[][] matrix = readMatrix(scanner,rows,cols,", ");

        int[][] subMatrix = new int[2][2];
        int bestSum = Integer.MIN_VALUE;


        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (currentSum > bestSum) {
                    bestSum = currentSum;

                    subMatrix[0][0] = matrix[row][col];
                    subMatrix[0][1] = matrix[row][col + 1];
                    subMatrix[1][0] = matrix[row + 1][col];
                    subMatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }

        for (int[] ints : subMatrix) {
            System.out.println(Arrays.toString(ints)
                    .replaceAll("[\\[\\],]", ""));
        }
        System.out.println(bestSum);
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {

        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];
            if (firstArr.length != secondArr.length) {
                return false;
            }
            for (int col = 0; col < firstArr.length; col++) {
                int firstElement = firstArr[col];
                int secondElement = secondArr[col];
                if (firstElement != secondElement) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] array = readArray(scanner, pattern);
            matrix[row] = array;
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

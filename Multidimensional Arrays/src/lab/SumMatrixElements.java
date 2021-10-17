package lab;

import java.util.*;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = readArray(scanner, ", ");
        int rows = array[0];
        int cols = array[1];

        int[][] matrix = readMatrix(scanner, rows, cols, ", ");

        int total = 0;

        for (int[] ints : matrix) {
            for (int num : ints) {
                total += num;
            }
        }

        System.out.println(matrix.length);
//        System.out.println(rows);
        System.out.println(matrix[0].length);
//        System.out.println(cols);
        System.out.println(total);
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

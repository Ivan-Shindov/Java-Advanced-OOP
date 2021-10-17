package lab;

import java.util.*;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] firstMatrix = readMatrix(scanner,rows,cols,"\\s+");

        dimensions = readArray(scanner);
        rows = dimensions[0];
        cols = dimensions[1];

        int[][] secondMatrix = readMatrix(scanner,rows,cols,"\\s+");

        boolean areEqual = compareMatrices(firstMatrix,secondMatrix);

        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

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

    private static int[][] readMatrix(Scanner scanner,int rows, int cols, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] array = readArray(scanner);
            matrix[row] = array;
        }
        return matrix;
    }
    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

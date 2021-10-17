package lab;

import java.util.*;

public class IntersectionTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                firstMatrix[row][col] = arr[col].charAt(0);
            }
        }

        char[][] secondMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                secondMatrix[row][col] = arr[col].charAt(0);
            }
        }

        char[][] outputMatrix = new char[rows][cols];

        for (int row = 0; row < firstMatrix.length; row++) {
            char[] firstArr = firstMatrix[row];
            char[] secondArr = secondMatrix[row];

            for (int col = 0; col < firstArr.length; col++) {
                char symbol = firstArr[col] == secondArr[col] ? firstArr[col] : '*';
                outputMatrix[row][col] = symbol;
//                System.out.print(symbol + " ");
            }
//            System.out.println();
        }

        for (char[] matrix : outputMatrix) {
            for (char symbol : matrix) {
                System.out.print(symbol + " ");
            }
            System.out.println();
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

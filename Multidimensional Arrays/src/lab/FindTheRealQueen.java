package lab;

import java.util.*;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];
        for (int row = 0; row < matrix.length; row++) {
            String[] current = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = current[col].charAt(0);
            }
        }

//        int[] result = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];

                int rowIn = row;
                int colIn = col;

                boolean flag = true;
                char current = ' ';

                while (rowIn > 0) {    // нагоре
                    current = matrix[rowIn - 1][colIn];
                    if (symbol == current) {
                        flag = false;
                        break;
                    }
                    rowIn--;
                }

                rowIn = row;
                colIn = col;

                while (rowIn < matrix.length - 1) {    // надолу
                    current = matrix[rowIn + 1][colIn];
                    if (symbol == current) {
                        flag = false;
                        break;
                    }
                    rowIn++;
                }

                rowIn = row;
                colIn = col;

                while (colIn > 0) {    // наляво
                    current = matrix[rowIn][colIn - 1];
                    if (symbol == current) {
                        flag = false;
                        break;
                    }
                    colIn--;
                }

                rowIn = row;
                colIn = col;

                while (colIn < matrix.length - 1) {   // надясно
                    current = matrix[rowIn][colIn + 1];
                    if (symbol == current) {
                        flag = false;
                        break;
                    }
                    colIn++;
                }

                rowIn = row;
                colIn = col;

                while (rowIn > 0 && colIn > 0) {   // диагонал наляво и нагоре
                    current = matrix[rowIn - 1][colIn - 1];
                    if (symbol == current) {
                        flag = false;
                        break;
                    }
                    rowIn--;
                    colIn--;
                }

                rowIn = row;
                colIn = col;

                while (rowIn > 0 && colIn < matrix.length - 1) {  // диагонал надясно и нагоре
                    current = matrix[rowIn - 1][colIn + 1];
                    if (symbol == current) {
                        flag = false;
                        break;
                    }
                    rowIn--;
                    colIn++;
                }

                rowIn = row;
                colIn = col;

                while (rowIn < matrix.length - 1 && colIn > 0) {  // диагонал надолу и наляво
                    current = matrix[rowIn + 1][colIn - 1];
                    if (symbol == current) {
                        flag = false;
                        break;
                    }
                    rowIn++;
                    colIn--;
                }

                rowIn = row;
                colIn = col;

                while (rowIn < matrix.length - 1 && colIn < matrix.length - 1) {  // диагонал надолу и надясно
                    current = matrix[rowIn + 1][colIn + 1];
                    if (symbol == current) {
                        flag = false;
                        break;
                    }
                    rowIn++;
                    colIn++;
                }

                if (flag) {
                    System.out.print(row + " ");
                    System.out.println(col);
                }
            }
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

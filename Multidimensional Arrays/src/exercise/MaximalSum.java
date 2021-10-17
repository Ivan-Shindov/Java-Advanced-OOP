package exercise;
import java.util.*;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = readArray(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        int [][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }

        int maxSum = Integer.MIN_VALUE;
        int indexRow = 0;
        int indexCol = 0;

        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                int currentSum = calculateMatrixSum(matrix,row,col);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    indexRow = row;
                    indexCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMaxSubMatrix(matrix,indexRow,indexCol);
    }

    private static void printMaxSubMatrix(int[][] matrix, int indexRow, int indexCol) {
        for (int row = indexRow - 1; row <= indexRow + 1; row++) {
            for (int col = indexCol - 1; col <= indexCol + 1; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int calculateMatrixSum(int[][] matrix, int row, int col) {
        int sum = 0;

        sum += matrix[row][col];
        //R
        sum += matrix[row][col + 1];
        //L
        sum += matrix[row][col - 1];
        //U
        sum += matrix[row - 1][col];
        //D
        sum += matrix[row + 1][col];
        //RU
        sum += matrix[row - 1][col + 1];
        //LU
        sum += matrix[row - 1][col - 1];
        //RD
        sum += matrix[row + 1][col + 1];
        //LD
        sum += matrix[row + 1][col - 1];
        return  sum;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

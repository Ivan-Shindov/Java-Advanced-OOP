package exercise;


import java.util.*;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        String[][] matrix = new String[rows][cols];

        char letter = 97;

        for (int row = 0; row < matrix.length; row++) {
            char changingLetter = (char) (97 + row);

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = letter + "" + changingLetter + "" + letter;
                changingLetter++;
            }
            letter++;
        }

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

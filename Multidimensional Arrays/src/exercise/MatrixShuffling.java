package exercise;

import java.util.*;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] text = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            text[i] = scanner.nextLine().split("\\s+");
        }
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            try {
                String[] tokens = input.split("\\s+");

                if (!tokens[0].equalsIgnoreCase("swap") || tokens.length > 5) {
                    throw new IllegalStateException();
                }

                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);
                String temp = text[row1][col1];

                text[row1][col1] = text[row2][col2];
                text[row2][col2] = temp;

                printMatrix(text);

            } catch (IndexOutOfBoundsException | IllegalStateException ex) {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }

    }

    private static void printMatrix(String[][] text) {
        for (int row = 0; row < text.length; row++) {
            for (int col = 0; col < text[row].length; col++) {
                System.out.print(text[row][col] + " ");
            }
            System.out.println();
        }
    }
}

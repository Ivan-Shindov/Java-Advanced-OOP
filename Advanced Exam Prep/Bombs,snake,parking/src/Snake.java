import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snake {

    public static int foodCount = 0;
    public static int snakeRow = -1;
    public static int snakeCol = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(buff.readLine());
        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            char[] array = buff.readLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = array[col];
                if (matrix[row][col] == 'S') {
                    snakeRow = row;
                    snakeCol = col;
                }
            }
        }


        while (foodCount < 10) {
            String command = buff.readLine();

            if (command.equals("up")) {
                // -1
                if (isInBounds(snakeRow - 1, snakeCol, matrix)) {
                    if (!moveInTheField(snakeRow, snakeCol,
                            snakeRow - 1, snakeCol, matrix)) {
                        snakeRow--;
                    }
                } else {
                    break;
                }
            } else if (command.equals("down")) {
                // +1
                if (isInBounds(snakeRow + 1, snakeCol, matrix)) {
                    if (!moveInTheField(snakeRow, snakeCol,
                            snakeRow + 1, snakeCol, matrix)) {
                        snakeRow++;
                    }
                } else {
                    break;
                }
            } else if (command.equals("left")) {
                // -1
                if (isInBounds(snakeRow, snakeCol - 1, matrix)) {
                    if (!moveInTheField(snakeRow, snakeCol,
                            snakeRow, snakeCol - 1, matrix)) {
                        snakeCol--;
                    }
                } else {
                    break;
                }

            } else if (command.equals("right")) {
                // +1
                if (isInBounds(snakeRow, snakeCol + 1, matrix)) {
                    if (!moveInTheField(snakeRow, snakeCol,
                            snakeRow, snakeCol + 1, matrix)) {
                        snakeCol++;
                    }
                } else {
                    break;
                }
            }
        }

        if (foodCount >= 10) {
            System.out.println("You won! You fed the snake.");
        } else {
            matrix[snakeRow][snakeCol] = '.';
            System.out.println("Game over!");
        }
        System.out.printf("Food eaten: %d%n", foodCount);
        printMatrix(matrix);
    }

    private static boolean moveInTheField(int oldRow, int oldCol,
                                          int newRow, int newCol, char[][] matrix) {
        if (matrix[newRow][newCol] == '-') {
            matrix[newRow][newCol] = 'S';
        } else if (matrix[newRow][newCol] == '*') {
            matrix[newRow][newCol] = 'S';
            foodCount++;
        } else if (matrix[newRow][newCol] == 'B') {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 'B' &&
                            (row != newRow || col != newCol)) {
                        matrix[newRow][newCol] = '.';
                        matrix[oldRow][oldCol] = '.';
                        matrix[row][col] = 'S';
                        snakeRow = row;
                        snakeCol = col;
                        return true;
                    }
                }
            }
        }
        matrix[oldRow][oldCol] = '.';
        return false;
    }

    private static boolean isInBounds(int row, int col, char[][] matrix) {
        if ((row >= 0 && row < matrix.length)
                && (col >= 0 && col < matrix[row].length)) {
            return true;
        }
        return false;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Revolt {
    public static int playerRow = -1;
    public static int playerCol = -1;
    public static boolean isFoundLetterF = false;

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(buff.readLine());
        int commandCount = Integer.parseInt(buff.readLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            char[] arr = buff.readLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = arr[col];
                if (arr[col] == 'f') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        while (commandCount > 0) {
            String command = buff.readLine();

            switch (command) {
                case "up":
                    // row -1
                    if (isInBounds(playerRow - 1, playerCol, matrix)) {
                        makeStepInMatrix(playerRow - 1, playerCol, matrix, command);

                    } else {
                        goesOutMethod(playerRow - 1, playerCol, matrix, size);
                    }
                    break;
                case "down":
                    // row +1
                    if (isInBounds(playerRow + 1, playerCol, matrix)) {
                        makeStepInMatrix(playerRow + 1, playerCol, matrix, command);
                    } else {
                        goesOutMethod(playerRow + 1, playerCol, matrix, size);
                    }
                    break;
                case "left":
                    // col -1
                    if (isInBounds(playerRow, playerCol - 1, matrix)) {
                        makeStepInMatrix(playerRow, playerCol - 1, matrix, command);
                    } else {
                        goesOutMethod(playerRow, playerCol - 1, matrix, size);
                    }
                    break;
                case "right":
                    // col + 1
                    if (isInBounds(playerRow, playerCol + 1, matrix)) {
                        makeStepInMatrix(playerRow, playerCol + 1, matrix, command);
                    } else {
                        goesOutMethod(playerRow, playerCol + 1, matrix, size);
                    }
                    break;
            }

            if (isFoundLetterF) {
                break;
            }

            commandCount--;
        }

        if (isFoundLetterF) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);
    }

    private static void makeStepInMatrix(int row, int col,
                                         char[][] matrix, String command) {
        switch (command) {
            case "up":                             // row -1
                if (matrix[row][col] == 'B') {
                    matrix[row + 1][col] = '-';
                    row--;
                    if (row == -1) {
                        goesOutMethod(row,col,matrix, matrix.length,'B');
                        return;
                    } else {
                        isTheStepF(row, col, matrix);
                    }
                } else if (matrix[row][col] == 'T') {
                    matrix[row + 1][col] = 'f';
                    row++;
                } else if (matrix[row][col] == '-') {
                    matrix[row][col] = 'f';
                    matrix[row + 1][col] = '-';
                } else {
                    matrix[row + 1][col] = '-';
                    matrix[row][col] = 'f';
                    isFoundLetterF = true;
                }
                break;
            case "down":                           // row +1
                if (matrix[row][col] == 'B') {
                    matrix[row - 1][col] = '-';
                    row++;
                    if (row == matrix.length) {
                        goesOutMethod(row,col,matrix, matrix.length,'B');
                        return;
                    } else {
                        isTheStepF(row, col, matrix);
                    }
                } else if (matrix[row][col] == 'T') {
                    matrix[row - 1][col] = 'f';
                    row--;
                } else if (matrix[row][col] == '-') {
                    matrix[row][col] = 'f';
                    matrix[row - 1][col] = '-';
                } else {
                    matrix[row - 1][col] = '-';
                    matrix[row][col] = 'f';
                    isFoundLetterF = true;
                }
                break;
            case "left":                             // col - 1
                if (matrix[row][col] == 'B') {
                    matrix[row][col + 1] = '-';
                    col--;
                    if (col == -1) {
                        goesOutMethod(row,col,matrix, matrix.length,'B');
                        return;
                    } else {
                        isTheStepF(row, col, matrix);
                    }
                } else if (matrix[row][col] == 'T') {
                    matrix[row][col + 1] = 'f';
                    col++;
                } else if (matrix[row][col] == '-') {
                    matrix[row][col] = 'f';
                    matrix[row][col + 1] = '-';
                } else {
                    matrix[row][col + 1] = '-';
                    matrix[row][col] = 'f';
                    isFoundLetterF = true;
                }
                break;
            case "right":                               // col + 1
                if (matrix[row][col] == 'B') {
                    matrix[row][col - 1] = '-';
                    col++;
                    if (col == matrix.length) {
                        goesOutMethod(row,col,matrix, matrix.length,'B');
                        return;
                    } else {
                        isTheStepF(row, col, matrix);
                    }
                } else if (matrix[row][col] == 'T') {
                    matrix[row][col - 1] = 'f';
                    col--;
                } else if (matrix[row][col] == '-') {
                    matrix[row][col] = 'f';
                    matrix[row][col - 1] = '-';
                } else {
                    matrix[row][col - 1] = '-';
                    matrix[row][col] = 'f';
                    isFoundLetterF = true;
                }
                break;
        }

        playerRow = row;
        playerCol = col;
    }

    private static void isTheStepF(int row, int col, char[][] matrix) {
        if (matrix[row][col] == 'F') {
            isFoundLetterF = true;
            matrix[row][col] = 'f';
        } else {
            matrix[row][col] = 'f';
        }
    }

    private static void goesOutMethod(int row, int col,
                                      char[][] matrix, int length, char letter) {
        if (letter == 'B') {
            if (row == -1) {
                playerRow = length - 1;
            } else if (row == length) {
                playerRow = 0;
            } else if (col == -1) {
                playerCol = length - 1;
            } else if (col == length) {
                playerCol = 0;
            }
        }
        isTheStepF(playerRow, playerCol, matrix);
    }

    private static void goesOutMethod(int row, int col,
                                      char[][] matrix, int size) {
        if (row == -1) {
            matrix[row + 1][col] = '-';
            playerRow = size - 1;
        } else if (row == size) {
            matrix[row - 1][col] = '-';
            playerRow = 0;
        } else if (col == -1) {
            matrix[row][col + 1] = '-';
            playerCol = size - 1;
        } else if (col == size) {
            matrix[row][col - 1] = '-';
            playerCol = 0;
        }

        isTheStepF(playerRow, playerCol, matrix);


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

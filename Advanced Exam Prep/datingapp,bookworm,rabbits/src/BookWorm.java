import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookWorm {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder initial = new StringBuilder(buff.readLine());
        int size = Integer.parseInt(buff.readLine());
        int playerRow = -1;
        int playerCol = -1;

        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            char[] arr = buff.readLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = arr[col];
                if (arr[col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        String command = buff.readLine();

        while (!command.equals("end")) {

            char currentChar;
            switch (command) {
                case "up":
                    // row - 1
                    if (isInBounds(playerRow - 1, playerCol, matrix)) {
                        playerRow--;
                        currentChar = matrix[playerRow][playerCol];
                        if (Character.isLetter(currentChar) && currentChar != 'P') {
                            initial.append(currentChar);
                            matrix[playerRow][playerCol] = 'P';
                            matrix[playerRow + 1][playerCol] = '-';
                        } else if (currentChar == '-') {
                            setPosition(playerRow, playerCol, matrix, command);
                        }
                    } else {
//                        if (initial.length() > 0) {
                        initial.deleteCharAt(initial.length() - 1);
//                        }
                    }
                    break;
                case "down":
                    // row + 1
                    if (isInBounds(playerRow + 1, playerCol, matrix)) {
                        playerRow++;
                        currentChar = matrix[playerRow][playerCol];
                        if (Character.isLetter(currentChar) && currentChar != 'P') {
                            initial.append(currentChar);
                            matrix[playerRow][playerCol] = 'P';
                            matrix[playerRow - 1][playerCol] = '-';
                        } else if (currentChar == '-') {
                            setPosition(playerRow, playerCol, matrix, command);
                        }
                    } else {
//                        if (initial.length() > 0) {
                        initial.deleteCharAt(initial.length() - 1);
//                        }
                    }
                    break;
                case "left":
                    // col - 1
                    if (isInBounds(playerRow, playerCol - 1, matrix)) {
                        playerCol--;
                        currentChar = matrix[playerRow][playerCol];
                        if (Character.isLetter(currentChar) && currentChar != 'P') {
                            initial.append(currentChar);
                            matrix[playerRow][playerCol] = 'P';
                            matrix[playerRow][playerCol + 1] = '-';
                        } else if (currentChar == '-') {
                            setPosition(playerRow, playerCol, matrix, command);
                        }
                    } else {
//                        if (initial.length() > 0) {
                        initial.deleteCharAt(initial.length() - 1);
//                        }
                    }
                    break;
                case "right":
                    // col + 1
                    if (isInBounds(playerRow, playerCol + 1, matrix)) {
                        playerCol++;
                        currentChar = matrix[playerRow][playerCol];
                        if (Character.isLetter(currentChar) && currentChar != 'P') {
                            initial.append(currentChar);
                            matrix[playerRow][playerCol] = 'P';
                            matrix[playerRow][playerCol - 1] = '-';
                        } else if (currentChar == '-') {
                            setPosition(playerRow, playerCol, matrix, command);
                        }
                    } else {
//                        if (initial.length() > 0) {
                        initial.deleteCharAt(initial.length() - 1);
//                        }
                    }
                    break;
            }


            command = buff.readLine();
        }

        System.out.println(initial.toString());
        printMatrix(matrix);
    }

    private static void setPosition(int playerRow, int playerCol, char[][] matrix, String command) {
        switch (command) {
            case "up":  // row - 1
                matrix[playerRow][playerCol] = 'P';
                matrix[playerRow + 1][playerCol] = '-';
                break;
            case "down":  // row + 1
                matrix[playerRow][playerCol] = 'P';
                matrix[playerRow - 1][playerCol] = '-';
                break;
            case "left":  // col - 1
                matrix[playerRow][playerCol] = 'P';
                matrix[playerRow][playerCol + 1] = '-';
                break;
            case "right":        // col + 1
                matrix[playerRow][playerCol] = 'P';
                matrix[playerRow][playerCol - 1] = '-';
                break;
        }

        matrix[playerRow][playerCol] = 'P';
        matrix[playerRow][playerCol] = '-';
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int row, int col, char[][] matrix) {
        if ((row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[row].length)) {
            return true;
        }
        return false;

    }
}

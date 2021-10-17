import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bee {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(buff.readLine());
        int beeRow = -1;
        int beeCol = -1;
        int pollinatedFlowers = 0;
        boolean isGotLost = false;

        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            char[] arr = buff.readLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = arr[col];
                if (arr[col] == 'B') {
                    beeRow = row;
                    beeCol = col;
                }
            }
        }

        String command = buff.readLine();

        while (!command.equals("End")) {

            char element;
            switch (command) {
                case "up":     //row - 1
                if (isInBounds(beeRow - 1,beeCol,matrix)) {
                    beeRow--;
                    element = matrix[beeRow][beeCol];

                    if (element == 'f') {
                        pollinatedFlowers++;
                        matrix[beeRow][beeCol] = 'B';
                        matrix[beeRow + 1][beeCol] = '.';

                    } else if (element == 'O') {
                        if (isInBounds(beeRow - 1,beeCol,matrix)) {
                            matrix[beeRow][beeCol] = '.';
                            if (matrix[beeRow - 1][beeCol] == 'f') {
                                pollinatedFlowers++;
                            }
                            matrix[beeRow - 1][beeCol] = 'B';
                            matrix[beeRow + 1][beeCol] = '.';
                            beeRow--;
                        } else {
                            matrix[beeRow][beeCol] = 'B';
                            matrix[beeRow + 1][beeCol] = '.';
                            isGotLost = true;
                            break;
                        }
                    } else {
                        matrix[beeRow][beeCol] = 'B';
                        matrix[beeRow + 1][beeCol] = '.';
                    }
                } else {
                    isGotLost = true;
                    break;
                }
                    break;
                case "down":         // row + 1
                    if (isInBounds(beeRow + 1,beeCol,matrix)) {
                        beeRow++;
                        element = matrix[beeRow][beeCol];

                        if (element == 'f') {
                            pollinatedFlowers++;
                            matrix[beeRow][beeCol] = 'B';
                            matrix[beeRow - 1][beeCol] = '.';

                        } else if (element == 'O') {
                            if (isInBounds(beeRow + 1,beeCol,matrix)) {
                                matrix[beeRow][beeCol] = '.';
                                if (matrix[beeRow + 1][beeCol] == 'f') {
                                    pollinatedFlowers++;
                                }
                                matrix[beeRow + 1][beeCol] = 'B';
                                matrix[beeRow - 1][beeCol] = '.';
                                beeRow++;
                            } else {
                                matrix[beeRow][beeCol] = 'B';
                                matrix[beeRow - 1][beeCol] = '.';
                                isGotLost = true;
                                break;
                            }
                        } else {
                            matrix[beeRow][beeCol] = 'B';
                            matrix[beeRow - 1][beeCol] = '.';
                        }
                    } else {
                        isGotLost = true;
                        break;
                    }
                    break;
                case "left":        // col - 1
                    if (isInBounds(beeRow,beeCol - 1,matrix)) {
                        beeCol--;
                        element = matrix[beeRow][beeCol];

                        if (element == 'f') {
                            pollinatedFlowers++;
                            matrix[beeRow][beeCol] = 'B';
                            matrix[beeRow][beeCol + 1] = '.';

                        } else if (element == 'O') {
                            if (isInBounds(beeRow,beeCol - 1,matrix)) {
                                matrix[beeRow][beeCol] = '.';
                                if (matrix[beeRow][beeCol - 1] == 'f') {
                                    pollinatedFlowers++;
                                }
                                matrix[beeRow][beeCol - 1] = 'B';
                                matrix[beeRow][beeCol + 1] = '.';
                                beeCol--;

                            } else {
                                matrix[beeRow][beeCol] = 'B';
                                matrix[beeRow][beeCol + 1] = '.';
                                isGotLost = true;
                                break;
                            }
                        } else {
                            matrix[beeRow][beeCol] = 'B';
                            matrix[beeRow][beeCol + 1] = '.';
                        }
                    } else {
                        isGotLost = true;
                        break;
                    }
                    break;
                case "right":       // col + 1
                    if (isInBounds(beeRow,beeCol + 1,matrix)) {
                        beeCol++;
                        element = matrix[beeRow][beeCol];

                        if (element == 'f') {
                            pollinatedFlowers++;
                            matrix[beeRow][beeCol] = 'B';
                            matrix[beeRow][beeCol - 1] = '.';

                        } else if (element == 'O') {
                            if (isInBounds(beeRow,beeCol + 1,matrix)) {
                                matrix[beeRow][beeCol] = '.';
                                if (matrix[beeRow][beeCol + 1] == 'f') {
                                    pollinatedFlowers++;
                                }
                                matrix[beeRow][beeCol + 1] = 'B';
                                matrix[beeRow][beeCol - 1] = '.';
                                beeCol++;

                            } else {
                                matrix[beeRow][beeCol] = 'B';
                                matrix[beeRow][beeCol - 1] = '.';
                                isGotLost = true;
                                break;
                            }
                        } else {
                            matrix[beeRow][beeCol] = 'B';
                            matrix[beeRow][beeCol - 1] = '.';
                        }
                    } else {
                        isGotLost = true;
                        break;
                    }
                    break;
            }

            if (isGotLost) {
                matrix[beeRow][beeCol] = '.';
                break;
            }

            command = buff.readLine();
        }

        if (isGotLost) {
            System.out.println("The bee got lost!");
        }
        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }

        printMatrix(matrix);
    }

    private static boolean isInBounds(int row, int col, char[][] matrix) {

    if ((row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[row].length)) {
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

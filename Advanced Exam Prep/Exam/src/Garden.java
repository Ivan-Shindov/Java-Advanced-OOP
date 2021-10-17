import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Garden {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        int[] sizes = Arrays.stream(buff.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = sizes[0];
        int cols = sizes[1];

        int[][] matrix = new int[rows][cols];

        List<int[]> lisOfIndexes = new ArrayList<>();

        String command = buff.readLine();

        while (!command.equals("Bloom Bloom Plow")) {
            int[] rowsAndCols = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int row = rowsAndCols[0];
            int col = rowsAndCols[1];

            int[] indexes = {row,col};
            lisOfIndexes.add(indexes);


            if (isInBounds(row,col,matrix)) {
                if (matrix[row][col] == 0) {
                    matrix[row][col] = 1;
                }

            } else {
                System.out.println("Invalid coordinates");
                continue;
            }

            command = buff.readLine();
        }

        for (int i = 0; i < lisOfIndexes.size(); i++) {

            int row = lisOfIndexes.get(i)[0];
            int col = lisOfIndexes.get(i)[1];

            int iterateRow = row;
            int iterateCol = col;
            // down -> row + 1
            while (iterateRow < matrix.length -1) {
                iterateRow++;
                matrix[iterateRow][col] += 1;
            }

            iterateRow = row;
            // up   row - 1
            while (iterateRow > 0) {
                iterateRow--;
                matrix[iterateRow][col] += 1;
            }

            iterateRow = row;
            // left  col - 1
            while (iterateCol > 0) {
                iterateCol--;
                matrix[row][iterateCol] += 1;
            }

            iterateCol = col;
            // right col + 1
            while (iterateCol < matrix[row].length - 1) {
                iterateCol++;
                matrix[row][iterateCol] += 1;
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int row, int col, int[][] matrix) {
        if ((row >= 0 && row < matrix.length)
                && (col >= 0 && col < matrix[row].length)) {
            return true;
        }
        return false;
    }
}

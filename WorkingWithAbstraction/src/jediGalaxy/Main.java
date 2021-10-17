package jediGalaxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = readArr(buff.readLine());
        int rows = dimensions[0];
        int cols = dimensions[1];

        Galaxy galaxy = new Galaxy(new BattleField(rows,cols));

        String command = buff.readLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediPositions = readArr(command);
            int[] sithPositions = readArr(buff.readLine());

            int jediRow = jediPositions[0];
            int jediCol = jediPositions[1];

            int sithRow = sithPositions[0];
            int sithCol = sithPositions[1];

            galaxy.moveSith(sithRow,sithCol);

            sum += galaxy.moveJedi(jediRow,jediCol);

            command = buff.readLine();
        }

        System.out.println(sum);
    }

    private static int[] readArr(String input) {
        return Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}

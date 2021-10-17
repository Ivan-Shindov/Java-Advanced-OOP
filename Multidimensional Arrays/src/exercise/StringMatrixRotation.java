package exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("([A-Za-z]+)\\((?<num>[0-9]+)\\)");
        Matcher matcher = pattern.matcher(input);
        int rotation = 0;
        if (matcher.find()) {
            rotation = Integer.parseInt(matcher.group("num"));
        }

        input = "";

        String text = "";
        int maxLength = 0;

        while (!(input = scanner.nextLine()).equals("END")) {
            text += input + "\n";

            if (input.length() > maxLength) {
                maxLength = input.length();
            }
        }

        String[] array = text.split("\n");

        StringBuilder output = new StringBuilder();
        rotation %= 360;

        switch (rotation) {
            case 0:
                System.out.println(text);
                break;
            case 90:
                for (int row = 0; row < maxLength; row++) {
                    for (int col = array.length - 1; col >= 0; col--) {

                        try {
                            output.append(array[col].charAt(row));
                        } catch (Exception e) {
                            output.append(" ");
                        }
                    }

                    output.append("\n");

                }
                System.out.println(output);
                break;
            case 180:
                System.out.println(new StringBuilder(text).reverse());
                break;
            case 270:
                for (int row = 0; row < maxLength; row++) {
                    for (int col = array.length - 1; col >= 0; col--) {

                        try {
                            output.append(array[col].charAt(row));
                        } catch (Exception e) {
                            output.append(" ");
                        }
                    }

                    output.append("\n");

                }
                System.out.println(output.reverse());
                break;
        }
    }
}

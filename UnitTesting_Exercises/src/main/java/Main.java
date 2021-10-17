import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ListIterator listIterator = null;
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Create":
                    try {
                        String[] valueArr = new String[tokens.length - 1];
                        int index = 1;
                        for (int i = 0; i < valueArr.length; i++) {
                            valueArr[i] = tokens[index];
                            index++;
                        }
                        listIterator = new ListIterator(valueArr);
                    } catch (OperationNotSupportedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;
                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "Print":
                    try {
                        System.out.println(listIterator.print());
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}

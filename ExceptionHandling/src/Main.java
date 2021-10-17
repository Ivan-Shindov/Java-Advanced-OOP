import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isPrint = false;

        while (!isPrint) {
            try {
                isPrint = willNumbersPrint(scanner);
            } catch (MyException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    private static int[] getArrayNums(Scanner scanner) {
        int[] arr = new int[2];
        arr[0] = getNum(scanner);
        arr[1] = getNum(scanner);

        return arr;
    }

    private static void printNumbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }
    }

    private static boolean isNumberInDiapason(int num) {
        return num > 0 && num <= 100;
    }

    private static int getNum(Scanner scanner) {
        int num = Integer.parseInt(scanner.nextLine());
        if (isNumberInDiapason(num)) {
            return num;
        }
        throw new MyException();
    }

    private static boolean willNumbersPrint(Scanner scanner) {
        try {
            int[] numbers = getArrayNums(scanner);
            printNumbers(numbers[0], numbers[1]);
            return true;
        } catch (IllegalArgumentException ex) {
            throw new MyException();
        }
    }
}

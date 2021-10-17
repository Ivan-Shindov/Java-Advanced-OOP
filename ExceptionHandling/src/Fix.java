import java.util.Scanner;

public class Fix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] weekdays = new String[5];
        initializeArr(weekdays);

        for (int i = 0; i <= weekdays.length; i++) {
            try {
                System.out.println(weekdays[i]);
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
    }

    private static void initializeArr(String[] weekdays) {
        weekdays[0] = "Monday";
        weekdays[1] = "Tuesday";
        weekdays[2] = "Wednesday";
        weekdays[3] = "Thursday";
        weekdays[4] = "Friday";
    }
}

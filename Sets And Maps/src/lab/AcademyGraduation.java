package lab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String,double[]> studentsAndGrades = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());;

        while (n-- > 0) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            studentsAndGrades.putIfAbsent(name,new double[grades.length]);
            studentsAndGrades.put(name,grades);
        }

        for (Map.Entry<String, double[]> entry : studentsAndGrades.entrySet()) {
            System.out.printf("%s is graduated with %s%n",
                    entry.getKey(),getAverage(entry.getValue()));
        }
    }

    private static String getAverage(double[] grades) {
        double grade = 0.;

        for (double g : grades) {
            grade +=g;
        }

        return String.valueOf(grade / grades.length);
    }
}

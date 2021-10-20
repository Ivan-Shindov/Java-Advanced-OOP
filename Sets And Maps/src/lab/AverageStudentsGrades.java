package lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, ArrayList<Double>> studentsAndGrades = new TreeMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            studentsAndGrades.putIfAbsent(name, new ArrayList<>());
            studentsAndGrades.get(name).add(grade);
        }

        studentsAndGrades.entrySet()
                .forEach(e -> System.out.printf("%s -> %s(avg: %.2f)%n",
                        e.getKey(),
                        getValueAsString(e.getValue()),
                        getAverage(e.getValue())
                ));
    }

    private static double getAverage(ArrayList<Double> grades) {
        double average = 0.00;

        for (Double grade : grades) {
            average += grade;
        }

        return average / grades.size();
    }

    private static String getValueAsString(ArrayList<Double> grades) {
        StringBuilder result = new StringBuilder();

        for (Double grade : grades) {
            result.append(String.format("%.2f",grade)).append(" ");
        }

        return result.toString();
    }
}

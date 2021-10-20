package lab;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {

    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);

            people.add(person);
        }

        String criteria = scanner.nextLine();

        int ageCriteria = Integer.parseInt(scanner.nextLine());

        Predicate<Person> ageFilter = createAgeFilter(criteria, ageCriteria);

        String format = scanner.nextLine();

        Function<Person, String> formatter = createFormat(format);


        System.out.println(people.stream()
                .filter(ageFilter)
                .map(formatter)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static Function<Person, String> createFormat(String format) {
        if (format.equals("name")) {
            return p -> p.name;
        } else if (format.equals("age")) {
            return p -> String.valueOf(p.age);
        }
        return p -> p.name + " - " + p.age;
    }

    private static Predicate<Person> createAgeFilter(String criteria, int age) {
        if (criteria.equals("older")) {
            return p -> p.age >= age;
        }
        return p -> p.age <= age;
    }
}
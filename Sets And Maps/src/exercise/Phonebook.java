package exercise;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String,String> phone = new LinkedHashMap<>();

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("search")) {
                String searchName = scanner.nextLine();
                while (!searchName.equals("stop")) {
                    if (phone.containsKey(searchName)) {
                        System.out.printf("%s -> %s%n", searchName,
                                phone.get(searchName));
                    } else {
                        System.out.println("Contact " + searchName + " does not exist.");
                    }
                    searchName = scanner.nextLine();
                }
                break;
            } else {
                String name = line.split("-")[0];
                String number = line.split("-")[1];;
                phone.put(name,number);
            }
        }
    }
}

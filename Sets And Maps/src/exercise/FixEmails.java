package exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String,String> nameAndEmail = new LinkedHashMap<>();

        String name = scanner.nextLine();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            String substring = email.substring(email.lastIndexOf(".") + 1).toLowerCase();

            if (!(substring.equals("com")) && !(substring.equals("us"))
                    && !(substring.equals("uk"))) {
                nameAndEmail.put(name,email);
            }

            name = scanner.nextLine();
        }

        nameAndEmail.forEach((key,value) ->
                System.out.printf("%s -> %s%n",key,value));
    }
}
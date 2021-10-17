import student.InvalidPersonNameException;
import student.Student;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        try {
            Student student = new Student("4avdar","dasdas@f231");
        } catch (InvalidPersonNameException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }

    }
}

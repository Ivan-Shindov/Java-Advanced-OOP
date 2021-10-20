package lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Set<String> carPlates = new LinkedHashSet<>();

        while (!line.equals("END")) {

            int index = line.indexOf(",");
            String direction = line.substring(0, index);
            String carNumber = line.substring(index + 2);

            if (direction.equals("IN")) {
                carPlates.add(carNumber);
            } else {
                carPlates.remove(carNumber);
            }

            line = scanner.nextLine();
        }

        if (carPlates.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String carPlate : carPlates) {
                System.out.println(carPlate);
            }
        }
    }
}
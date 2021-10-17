package AnimalFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        String name = buff.readLine();
        int age = Integer.parseInt(buff.readLine());

        try {
           Chicken chicken = new Chicken(name,age);
            System.out.println(chicken.toString());
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

package NeedForSpeed;

public class Main {
    public static void main(String[] args) {

        FamilyCar familyCar = new FamilyCar(40,250);

        familyCar.drive(5);
        System.out.println(familyCar.getFuel());
    }
}

package christmas;

public class Main {
    public static void main(String[] args) {

        Bag bag = new Bag("black",10);

        Present present = new Present("Doll",0.4,"girl");


        Present heaviestPresent = bag.heaviestPresent();
        System.out.println(heaviestPresent);

        System.out.println(bag.getPresent("Ivan"));

    }
}

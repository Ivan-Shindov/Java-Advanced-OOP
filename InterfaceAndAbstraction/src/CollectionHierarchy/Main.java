package CollectionHierarchy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = buff.readLine().split("\\s+");

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();

        for (String token : tokens) {
            int add1 = addCollection.add(token);
            sb1.append(add1).append(" ");
            int add2 = addRemoveCollection.add(token);
            sb2.append(add2).append(" ");
            int add3 = myList.add(token);
            sb3.append(add3).append(" ");
        }

        int amountOfRemoving = Integer.parseInt(buff.readLine());

        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();

        while (amountOfRemoving-- > 0) {
            String removed1 = addRemoveCollection.remove();
            sb4.append(removed1).append(" ");
            String removed2 = myList.remove();
            sb5.append(removed2).append(" ");
        }

        System.out.println(sb1.toString().trim());
        System.out.println(sb2.toString().trim());
        System.out.println(sb3.toString().trim());
        System.out.println(sb4.toString().trim());
        System.out.println(sb5.toString().trim());
    }
}

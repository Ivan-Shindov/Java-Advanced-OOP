package Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

       double length = Double.parseDouble(buff.readLine());
       double width = Double.parseDouble(buff.readLine());
       double height = Double.parseDouble(buff.readLine());

       try {
           Box box = new Box(length,width,height);
           System.out.println(box.toString());
       } catch (IllegalArgumentException ex ) {
           System.out.println(ex.getMessage());
       }

    }
}

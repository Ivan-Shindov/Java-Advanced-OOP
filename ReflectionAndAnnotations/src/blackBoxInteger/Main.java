package blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException, NoSuchMethodException {

        Class<?> clazz = Class.forName("blackBoxInteger.BlackBoxInt");

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        BlackBoxInt blackBoxInt = null;
        try {
            constructor.setAccessible(true);
            blackBoxInt =(BlackBoxInt) constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        String line = buff.readLine();
        StringBuilder output = new StringBuilder();

        while (!line.equals("END")) {
            String[] tokens = line.split("_");
            String commandName = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            try {
                Method method = clazz.getDeclaredMethod(commandName, int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, value);
                Field innerValue = clazz.getDeclaredField("innerValue");
                innerValue.setAccessible(true);
                output.append(innerValue.getInt(blackBoxInt)).append(System.lineSeparator());
            } catch (NoSuchMethodException | IllegalAccessException |
                    InvocationTargetException | NoSuchFieldException e) {
                e.printStackTrace();
            }

            line = buff.readLine();
        }
        System.out.println(output.toString());
    }
}

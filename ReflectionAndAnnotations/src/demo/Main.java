package demo;

import demo.Subject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        Class<?> clazz = Class.forName("demo.Reflection");

//        Class<Reflection> clazz = Reflection.class;
////        System.out.println(ref);

        Subject anno = clazz.getAnnotation(Subject.class);

        for (String category : anno.categories()) {
            System.out.println(category);
        }

    }
}

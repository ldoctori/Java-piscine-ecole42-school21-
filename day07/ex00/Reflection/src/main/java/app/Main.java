package app;

import classes.*;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static String someClass;
    private static final String classCar = "Car";
    private static final String classUser = "User";
    private static String requiredClass;
    private static Scanner sc;
    private static Class reqClass;
    private static Field[] fields;
    private static Method[] methods;
    private static Object myObj;


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        sc = new Scanner(System.in);
        printClassList();
        setRequiredClass();
        loadReqClass();
        printDelimiter();
        createObject();
        printDelimiter();
        changeObject(myObj);
        printDelimiter();
        runMethod();
    }

    private static void runMethod() throws InvocationTargetException, IllegalAccessException {

        System.out.println("Enter name of the method for call:");
        String someMethod = sc.nextLine();
        for (Method m : methods) {
            if (someMethod.equals(m.getName() + "(" + m.getReturnType() + ")") == true) {
                System.out.println("Enter " + m.getReturnType() + " value:");
                Object param = sc.nextInt();
                System.out.println("Method returned:\n" + m.invoke(myObj, param));
                return;
            }
        }
        System.out.println("No such method!");
        runMethod();
    }
    private static void createObject() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        System.out.println("Let’s create an object.");
        Parameter[] parameters = null;
        int i;
        Constructor <?>[] constructors = reqClass.getDeclaredConstructors();
        for (i = 0; i < constructors.length; i++) {
            if (constructors[i].getParameterCount() > 0) {
                parameters = constructors[i].getParameters();
                break ;
            }
        }
        List<Object> paramsList = new ArrayList<>();
        for (int j = 0; j < parameters.length; j++) {
            System.out.println(fields[j].getName() + ":");
            paramsList.add(getValue(parameters[j].getType().getSimpleName()));
        }
        myObj = constructors[i].newInstance(paramsList.toArray());
        System.out.println("Object created: " + myObj.getClass().getDeclaredMethod("toString").invoke(myObj));
    }

    private static Object getValue(String type) throws IllegalAccessException {

        if (type.equals("String")) {
            String some = sc.nextLine();
            return some;
        } else if (type.equals("int")) {
            String some = sc.nextLine();
            return Integer.parseInt(some);
        }
        return null;
    }

    private static void changeObject(Object myObj) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        System.out.println("Enter name of the field for changing:");

        for (Field f : fields) {
            System.out.println(f.getName() + ":");
            f.setAccessible(true);
            f.set(myObj, getValue(f.getType().getSimpleName()));
        }
        System.out.println("Object updated: " + myObj.getClass().getDeclaredMethod("toString").invoke(myObj));
    }

    private static void loadReqClass() throws ClassNotFoundException {

        reqClass = ClassLoader.getSystemClassLoader().loadClass("classes." + requiredClass);
        fields = reqClass.getDeclaredFields();
        methods = reqClass.getDeclaredMethods();

        System.out.println("fields:");
        for (Field f : fields) {
            System.out.println("    " + f.getType().getSimpleName() + " " + f.getName());
        }
        System.out.println("methods:");
        for (Method m : methods) {
            if (m.getName().equals("toString") == false) {
                System.out.println("    " + m.getReturnType().getSimpleName()
                                    + " " + m.getName() + "(" + m.getReturnType() + ")");
            }
        }
    }

    private static void setRequiredClass() {

        System.out.println("Enter class:");
        requiredClass = sc.nextLine();
        while ((requiredClass.equals(classCar) == false)
                && (requiredClass.equals(classUser) == false)) {
            System.out.println("Enter one of the classes listed below");
            requiredClass = sc.nextLine();
        }
        printDelimiter();
    }

    private static void printClassList() {

        System.out.println("Classes:");
        System.out.println(classUser);
        System.out.println(classCar);
        printDelimiter();

    }

    private static void printDelimiter() {
        System.out.println("---------------------");
    }

}

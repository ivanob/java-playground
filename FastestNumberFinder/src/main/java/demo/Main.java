package demo;

import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println("Application started");
        MyFastestComparator fastestComparator = new MyFastestComparator();
        List<CustomNumberEntity> l = fastestComparator.readFromFile("src/main/resources/list1.json");
        int numberToFind = 100;
        System.out.println("Is the number " + numberToFind + " contained the list? " + fastestComparator.contains(numberToFind, l));
    }
}

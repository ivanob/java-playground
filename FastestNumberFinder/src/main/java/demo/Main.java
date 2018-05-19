package demo;

import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello");
        MyFastestComparator fastestComparator = new MyFastestComparator();
        List<CustomNumberEntity> l = fastestComparator.readFromFile("src/main/resources/list1.json");
        System.out.println(fastestComparator.contains(100, l));
    }
}

package demo;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello");
        MyFastestComparator fastestComparator = new MyFastestComparator();
        fastestComparator.readFromFile("src/main/resources/list1.json");
    }
}

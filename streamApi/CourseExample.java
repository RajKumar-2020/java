package streamApi;

import java.util.Arrays;
import java.util.List;

public class CourseExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Spring","Spring Boot","API","Microservices","AWS","Docker","Kuberntes");
        printAllCource(list);
        printContaingSpring(list);
        printLetterGreaterThanFour(list);
        printNumberofCharacter(list);
    }

    private static void printNumberofCharacter(List<String> list) {
        System.out.println("Print length of each character");
        list.stream().map(x -> x +" "+x.length()).forEach(System.out::println);
    }

    private static void printLetterGreaterThanFour(List<String> list) {
        System.out.println("Print all letter whose length greater than four");
        list.stream().filter(x->x.length()>4).forEach(System.out::println);
    }

    private static void printContaingSpring(List<String> list) {
        System.out.println("\nPrint word that contain spring");
        list.stream().filter(x-> x.contains("Spring")).forEach(System.out::println);
    }

    private static void printAllCource(List<String> list) {
        System.out.println("Print all cource");
        list.stream().map(x-> x+",").forEach(System.out::print);
    }
}

package streamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12,9,13,4,6,2,4,12,15);
        List<String> list1 = Arrays.asList("Spring","Spring Boot","API","Microservices","AWS","PCF");
        sumOfAllList(list);
        findGreatestNumber(list);
        findSquareOfSum(list);
        findSumOfOddNumber(list);
        findDistinctNumber(list);
        sortTheNumber(list);
        sortTheNumberInDesendingOrder(list);
        sortOfStringBasedOnLength(list1);
        collectListOfSquareNumber(list);
    }

    private static void collectListOfSquareNumber(List<Integer> list) {
        System.out.println("Collect List of square number");
        List<Integer>squareDouble = list.stream().map(x->x*x).collect(Collectors.toList());
//        squareDouble.forEach(System.out::println);
        System.out.println(squareDouble);
    }

    private static void sortTheNumberInDesendingOrder(List<Integer> list) {
        System.out.println("Sort Number in reverse order");
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void sortOfStringBasedOnLength(List<String> list1) {
        System.out.println("Sort list1 based on length");
        list1.stream().sorted((x,y)->x.length()-y.length()).forEach(System.out::println);
    }

    private static void sortTheNumber(List<Integer> list) {
        System.out.println("Sort the number");
        list.stream().sorted().forEach(System.out::println);
    }

    private static void findDistinctNumber(List<Integer> list) {
        System.out.println("Distinct number");
        list.stream().distinct().forEach(System.out::println);
    }

    private static void findSumOfOddNumber(List<Integer> list) {
        System.out.println("Sum of Odd Number");
        int num = list.stream().filter(x->x%2!=0).reduce(0,(x,y)->x+y);
        System.out.println(num);
    }

    private static void findSquareOfSum(List<Integer> list) {
        System.out.println("Square of sum");
        int num = list.stream().map(x->x*x).reduce(0,(x,y)->x+y);
        System.out.println(num);
    }

    private static void findGreatestNumber(List<Integer> list) {
        System.out.println("Greatest number");
       int greatestNumber= list.stream().reduce(Integer.MIN_VALUE,(x,y)->x>y?x:y);
       System.out.println(greatestNumber);
    }

    private static void sumOfAllList(List<Integer> list) {
        System.out.println("Sum of all list");
        int sum = list.stream().reduce(0,(x,y)->x+y);
        System.out.println(sum);
    }
}

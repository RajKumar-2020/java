package streamApi;

import java.util.Arrays;
import java.util.List;

public class StreamApi {
    public static void main(String args[]){
        List<Integer> list = Arrays.asList(25,5,8,9,20);
//        printAllNumber(list);
        printEvenNumber(list);
        printOddNumber(list);
        printSquareOfEvenNumber(list);
    }

    private static void printSquareOfEvenNumber(List<Integer> list) {
        list.stream().filter(x->x%2==0).map(x->x*x).forEach(System.out::println);
    }

    private static void printOddNumber(List<Integer> list) {
        list.stream().filter(x->x%2!=0).forEach(System.out::println);
    }

    private static void printEvenNumber(List<Integer> list) {
        list.stream().filter(x->x%2==0).forEach(System.out::println);
    }

    private static void printAllNumber(List<Integer> list) {
//        for(int a:list)
//        {
//            System.out.println(a);
//        }

//        list.stream().forEach(System.out::println);
        list.forEach(StreamApi::print);   // Method Reference
    }

    private static void print(int number)
    {
        System.out.println(number);
    }




}

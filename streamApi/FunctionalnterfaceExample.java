package streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalnterfaceExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(20,5,8,2,6);
        findSquareOfEven(list);
    }

    private static void findSquareOfEven(List<Integer> list) {

        // functional interface that has exactly one abstract method

        //Represent a predicate of one argument and return boolean value

        //like test something
        final Predicate<Integer> integerPredicate = x -> x % 2 == 0;
        //actual implementation of predicate
        final Predicate<Integer> integerPredicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number%2==0;
            }
        };

        // a function that accepts one arguments and produces a result
        final Function<Integer, Integer> integerFunction = x -> x * x;
        //actual implementation of function
        final Function<Integer, Integer> integerFunction1 =new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer number) {
                return number*number;
            }
        };


        // it accept a single input arguments and returns no result
        final Consumer<Integer> println = System.out::println;
        //actual implementation of function
        final Consumer<Integer> println1 = new Consumer<Integer>() {
            @Override
            public void accept(Integer number) {
                System.out.println(number);
            }
        };


        list.stream().filter(integerPredicate1).map(integerFunction1).forEach(println1);
    }
}

package com.example.jeedemo.functionalDemo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamApiDemo {

    private static final List<Integer> numbers = Collections.unmodifiableList(
        Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

    private static final Predicate<String> notEmpty = s -> !s.isEmpty();

    private static final List<String> names = Collections.unmodifiableList(
        Arrays.asList("Jhon, martha, lenon, aarya, soren")
    );

    public static void main(String[] args) {

        //map example
        String numText = numbers.stream()
            .map(Object::toString)
            .collect(joining(","));

        System.out.println("numText = " + numText);

        //filter example
        final String firstName = "ram";
        final String middleName = "";
        final String lastName = null;

        final String fullName = Stream.of(firstName, middleName, lastName)
            .filter(Objects::nonNull)
            .filter(StreamApiDemo.notEmpty)
            .collect(joining(" "));
        System.out.println("fullName = " + fullName);

        //reduce example


        int reduce1 = IntStream.range(1, 6)
            .parallel()
            .peek(i -> System.out.println(Thread.currentThread().getName()))//peek and foreach are different
            //peek is only for debugging purpose and non terminating operation
            .reduce(1, (e1, e2) -> e1 * e2);

        System.out.println("reduce1 = " + reduce1);

        //avoid large lambda expression
        names.stream()
            .forEach(s -> {
                //


                //..

            });


        //finding second largest in array

        System.out.println(
            numbers.stream()
                .sorted()
                .skip(numbers.size() - 2)
                .findFirst()
                .get()
        );

        IntStream.range(0, numbers.size())
            .map(i -> numbers.get(i))
            .peek(System.out::println)
            .filter(e -> e % 2 == 0)
            .forEach(System.out::println);

        // find max value index O(n)
        //replace with min value O(n)
        //find max O(n)


        Integer max = Collections.max(numbers);

        Arrays.asList(2.0).stream()
            .flatMapToInt(integer -> IntStream.builder().build());

//            .findFirst()
//            .ifPresent(System.out::println);


        Arrays.asList(Arrays.asList(2, 4, 6), Arrays.asList(1, 3, 5)).stream()
            .flatMap(list -> list.stream())
            .forEach(System.out::println);


    }
}

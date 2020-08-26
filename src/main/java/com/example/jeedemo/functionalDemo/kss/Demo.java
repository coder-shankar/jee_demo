package com.example.jeedemo.functionalDemo.kss;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {

    private final List<Integer> numbers = Collections.unmodifiableList(Arrays.asList(1,2,3,4,5,6,7,8,9));

    private static Integer multiply(Integer a, Integer acc) {
        System.out.println(a);
        return acc * a;
    }

    @Test
    void test123() {

        int result = 0;
        for (int i = 0; i < numbers.size() ; i++) {
            result += numbers.get(i);
        }
        System.out.println("result = " + result);

        numbers.stream().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("integer = " + integer);
            }
        });

        numbers.stream()
            .filter(e -> e % 2 == 0)
            .forEach(System.out::println);


          int x = 2;
        numbers.stream()
//            .filter(e -> e % x == 0)
            .forEach(new Consumer<Integer>() {
                @Override
                public void accept(Integer integer) {
                    System.out.println("x = " + x);
                }
            });


        Stream<Double> doubleStream = numbers.stream()
            .filter(e -> e % 2 != 0)
            .map(integer -> integer * Math.PI);

        System.out.println("doubleStream = " + doubleStream);

        doubleStream.reduce(0.0, (aDouble, aDouble2) -> aDouble + aDouble2);



        String fullName = Stream.of("ram", "", "shrestha")
            .filter(Objects::nonNull)
            .filter(e -> !e.isEmpty())
            .collect(Collectors.joining(" "));
        System.out.println("fullName = " + fullName);


        numbers.stream()
            .map(Integer::valueOf)
            .map(Object::toString)
            .forEach(System.out::println);


        numbers.stream()
            .reduce(1, Demo::multiply);

        Arrays.asList(Arrays.asList(2, 4, 6), Arrays.asList(1, 3, 5)).stream()
            .flatMap(list -> list.stream().map(e -> e * 2))
            .sorted()
            .forEach(System.out::println);

        Stream.concat(Arrays.asList(1,2).stream(), Arrays.asList(2,3).stream())
            .forEach(System.out::println);
        numbers.addAll()
        int index = 0;
        while (true) {
            if (index < numbers.size())
                joinList.add(numbers.get(index));
            if (index < numbers.size() )
                joinList.add(numbers.get(index));

            if (numbers.size() < numbers.size()) {
                if (numbers.size() == index)
                    break;
            }


        }






    }
}

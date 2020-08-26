package com.example.jeedemo.lamba;

import static java.lang.Thread.sleep;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Converter;
import lombok.SneakyThrows;

public class Pipeline {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 7, 8);

//        Integer sumOfEven = numbers.stream()
//                .filter(e -> e % 2 == 0)
//                .reduce(0, (acc, var) -> acc + var);
//
//        System.out.println("sumOfEven = " + sumOfEven);

//        numbers.parallelStream()
//                .map(e -> transform(e))
//                .forEachOrdered( System.out::println);

        //for each order cannot gurantee ordering

        Set<Integer> integerSet = new TreeSet<>();

        integerSet.add(1);
        integerSet.add(6);
        integerSet.add(2);
        integerSet.add(3);
        integerSet.add(4);
        integerSet.add(5);

        Integer evenSum = numbers.stream()
//            .filter(e -> e % 2 == 0)
            .reduce(1, (acc, var) -> acc + var);

        System.out.println("evenSum = " + evenSum);

//        numbers.stream()
//                .parallel()
//                .map(e -> transform(e))
//                .sequential()
//                .forEach(System.out::println);

//        sequential vs parallel
//        synchronized  vs async

    }

    @SneakyThrows
    private static Integer transform(Integer e) {
        System.out.println("number " + e + "---" + Thread.currentThread());
        sleep(1000);
        return e * 2;
    }
}

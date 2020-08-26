package com.example.jeedemo.functionalDemo;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Test {

    @SneakyThrows
    public static void main(String[] args) {
        //structure programming
        for (int i = 0; i < 5; i++) {

            if (i < 2)
                System.out.println("i = " + i);
        }


        //first class citizen
        Thread thread = new Thread(() -> System.out.println("Inside Thread"));
        thread.start();
        System.out.println("Demo.main");

        //single method abstract interface
        Arrays.asList(1, 2, 3, 4).stream()
            .forEach(new Consumer<Integer>() {
                @Override
                public void accept(Integer num) {
                    System.out.println(num);
                }
            });
        Arrays.asList(1, 2, 3, 4).stream()
            .forEach(new Consumer<Integer>() {
                @Override
                public void accept(Integer num) {
                    System.out.println(num);
                }
            });

        //consumer

        //supplier

        Supplier<MailerDemo> mailerSupplier = () -> {
//             mailer adder set
            return new MailerDemo();
        };

        MailerDemo mailerDemo = mailerSupplier.get();


        //function
        Function<Integer, Double> area = r -> Math.PI * r * r;
        area.apply(2);
        Consumer<Integer> print = e -> System.out.println("e = " + e);
        print.accept(1);
        Supplier<Double> supplyRandomNum = () -> Math.random();
        supplyRandomNum.get();


        BiFunction<Integer, Integer, Integer> areaOfRectangel = (l, b) -> l * b;
        BinaryOperator<Integer> add1 = (a, b) -> a + b;
        BiFunction<Integer, Integer, Double> doubleBiFunction = add1.andThen(area);

        Double apply = doubleBiFunction.apply(2, 3);
        System.out.println("apply = " + apply);


        BiFunction<Integer, Integer, Double> integerIntegerDoubleBiFunction = areaOfRectangel.andThen(Integer::doubleValue);
        Double result = integerIntegerDoubleBiFunction.apply(12, 3);
        System.out.println("result = " + result);


        Arrays.asList(1, 2, 3, 4).stream()
            .forEach(System.out::println);

        //calculate area of circle
        AreaService circleArea = r -> Math.PI * r * r;
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        numbers.stream()
            .map(circleArea::calculateArea)
            .forEach(System.out::println);

        //calculate area of circle
        AreaService squareArea = l -> l * l * 1.0;
        numbers.stream()
            .map(squareArea::calculateArea)
            .map(Double::intValue)
            .forEach(System.out::println);

        //sum of even number

        int res = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) res += numbers.get(i);
        }

        System.out.println("res = " + res);
        Predicate<Integer> evenPredicate = i -> i % 2 == 0;
        numbers.stream()
            .filter(evenPredicate)
            .mapToInt(Integer::intValue)
            .sum();


        //using reduce
        BinaryOperator<Integer> add = (a, b) -> a + b;
        UnaryOperator<Integer> increment = a -> a + 1;


        // no varialble mutation here
        Integer sumOfEven = numbers.stream()
            .filter(evenPredicate)//lazy, unbound
            .reduce(0, Test::sum);//not lazy, unbound
        System.out.println("sumOfEven = " + sumOfEven);

        //closure
        int addition = 5;
        int[] addi = new int[]{6};
        numbers.stream()
            .map(i -> i + addition)
            .forEach(System.out::println);

//        why immutable is important

        Stream<Integer> stream = numbers.stream()
            .map(i -> i + addi[0]);
//works for local variable olny not for array or class memeber variable

        addi[0] = 10;

        stream.forEach(System.out::println);


        //method reference
        numbers.stream()
            .map(String::valueOf) //here value of is static method
            .forEach(System.out::println);

        numbers.stream()
            .map(String::valueOf)//static method
            .map(String::toString)//instance method
            .forEach(System.out::println);

        //passing two paramter lambda
        //order matter here
        numbers.stream()
            .reduce(0, (acc, e) -> Integer.sum(acc, e));


        System.out.println(
            numbers.stream()
                .reduce(0, Integer::sum)
        );

        String collect = numbers.stream()
            .map(String::valueOf)
            .collect(joining(",", "-", "#"));
        System.out.println("collect = " + collect);

        //infinite stream
        //lazyness is very very import for infinite stream
        IntStream.iterate(0, i -> i + 2)
            .limit(100)
            .distinct()
            .sorted()
            .forEach(System.out::println);

        //stream property
//        sized, order, distinct, sorted


//        parallel steam
        System.out.println("Parallel stream");
        numbers.stream()
            .sequential()
//            .peek(e -> System.out.println(Thread.currentThread().getName()))
            .parallel() //latest operation will matter
            .forEach(integer -> {
            });

//        entire stream is parallel or sequential

//            [1, 2,3 ,4]


//        long start = System.currentTimeMillis();
//
//        Integer sumParallel = numbers.stream()
//            .parallel()
//            .peek(System.out::println)
//            .peek(e -> System.out.println(Thread.currentThread().getName()))
//            .reduce(0, (acc, r1) -> {
//                System.out.println("acc = " + acc);
//                return acc + r1;});
//
//        System.out.println("sumParallel = " + sumParallel);
//
//        System.out.println("TOtal time take "+ (System.currentTimeMillis() - start) );

//        long start = System.currentTimeMillis();
//
//        LongStream.iterate(1, i -> i + 1)
//            .limit(20)
//            .parallel()
//            .peek(e -> System.out.println(Thread.currentThread().getName()))
//            .forEach(System.out::println);
//
////        4237178, 17212727
//        System.out.println("TOtal time take " + (System.currentTimeMillis() - start));
//
        long start = System.currentTimeMillis();

        numbers.stream()
            .parallel()
            .peek(System.out::println)
            .filter(e -> e % 2 == 0)
            .findFirst();

        System.out.println("TOtal time take " + (System.currentTimeMillis() - start));


    }

    public static int sum(int var0, int var1) {
        return var0 + var1;
    }

//
//    js closure example
//    function  f1 () {
//        var last_name = "sharma";
//
//        return function (first_name) {
//            alert (first_name + last_name);
//        } }
//    var f2 = f1();
}

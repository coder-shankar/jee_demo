package com.example.jeedemo.npe;

import java.util.Optional;

public class Demo {

    public static void main(String[] args) {
        Optional<String> str = Optional.of("Hello this is non null demo");
        Optional<String> nullableString = Optional.ofNullable(null);
        Optional<String> emptyString = Optional.empty();

        str.ifPresent(System.out::println);

        boolean present = nullableString.isPresent();
        System.out.println("present = " + present);

    }

}

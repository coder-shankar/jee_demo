package com.example.jeedemo.functionalDemo;

import static java.lang.Math.PI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class Demo {

  public static void main(String[] args) {
    AreaService areaServiceForCircle = radius -> PI * radius * radius;
    AreaService areaServiceForSquare = parameter -> parameter * parameter *1.0;

    System.out.println("area of circle is :"+areaServiceForCircle.calculateArea(5));
    System.out.println("area of square is : "+areaServiceForSquare.calculateArea(10));

      List<String> names = new ArrayList<String>();
      names.add("shankar");
      names.add("ram");

    List<List<String>> immuatebleNames = Collections.singletonList(names);
    immuatebleNames.add(names);


    names.parallelStream().forEach(s -> printName(()->s));
  }

  public static void printName(Supplier<String> name){
    System.out.println(name.get());
  }
}

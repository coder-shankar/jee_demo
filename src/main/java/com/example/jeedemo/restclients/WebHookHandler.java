package com.example.jeedemo.restclients;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class WebHookHandler {

  public static void main(String[] args) {
      List l = new ArrayList();

      for (int i = 0;i<100;i++){
          l.add(i);
      }

      l.forEach(WebHookHandler::getHello);
      l.forEach(getHello());

  }

    private static void getHello(Object o) {
        System.out.println(o);
        System.out.println("hello");
    }

    private static Consumer<Integer> getHello() {
        return o -> {
            System.out.println(o);
            System.out.println("hello");
        };
    }
}

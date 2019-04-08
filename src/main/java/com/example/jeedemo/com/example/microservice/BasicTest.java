package com.example.jeedemo.com.example.microservice;

import static java.lang.System.out;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class BasicTest {

  @Test
  public void methodReeference() {

    Runnable runnable = this::display;
    new Thread(runnable).start();
  }

  void display() {
    out.println(LocalDate.now().getDayOfMonth());
  }
}

package com.example.jeedemo.base64;

import static java.lang.System.out;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class TestBase64 {

  @Test
  public void encode() {

    try {
      File file1 = new File("/home/shankar/Pictures/pubge.jpg");
      InputStream inputStream = new FileInputStream(file1);
      out.println(new Base64Stream().encodeUsingBuffer(inputStream));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

package com.example.jeedemo.base64;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import lombok.SneakyThrows;

public class Base64Stream {
  @SneakyThrows
  public String encode(InputStream in) {

    byte[] buffer = new byte[3072];

    int n;

    StringBuilder sb = new StringBuilder();

    Base64.Encoder encoder = Base64.getEncoder();

    while ((n = in.read(buffer)) != -1) {

      if (n < 3072) {

        byte[] lastBuffer = new byte[n];

        System.arraycopy(buffer, 0, lastBuffer, 0, n);

        sb.append(encoder.encodeToString(lastBuffer));

      } else {

        sb.append(encoder.encodeToString(buffer));
      }
    }

    return sb.toString();
  }

  @SneakyThrows
  public String encodeUsingBuffer(InputStream in) {

    byte[] buffer = new byte[3072];

    int n;

    Base64.Encoder encoder = Base64.getEncoder();

    ByteArrayOutputStream x = new ByteArrayOutputStream();

    OutputStream out = encoder.wrap(x);

    while ((n = in.read(buffer)) != -1) {

      out.write(buffer, 0, n);
    }

    return x.toString();
  }
}

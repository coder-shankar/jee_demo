package com.example.jeedemo.jaxb;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class unmarshalling {

  private final String xmlString = "<response><name>shankar</name><age>21</age></response>";

  @Test
  @SneakyThrows
  public void test1() {
    Person unmarshal =
        (Person)
            JAXBContext.newInstance(Person.class)
                .createUnmarshaller()
                .unmarshal(new StringReader(xmlString));
    System.out.println(unmarshal.toString());
  }
}

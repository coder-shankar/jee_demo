package com.example.jeedemo.functionalDemo;

import static java.lang.System.out;

import com.example.jeedemo.restclients.PersonalInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import javax.ws.rs.core.MultivaluedMap;

public class Currying {
  public final int a = 10;

  public static void main(String[] args) {

    PersonalInfo personalInfo = new PersonalInfo();
    personalInfo.setAge(12);
    personalInfo.setEmail("hello@hello.com");

    System.out.println("hello  ");

    ObjectMapper objectMapper = new ObjectMapper();
    MultivaluedMap<String, String> map =
        objectMapper.convertValue(personalInfo, new TypeReference<Map<String, Object>>() {});

    System.out.println(map.toString());
    out.println(map.get("email"));
  }

}

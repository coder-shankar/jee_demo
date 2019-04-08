package com.example.jeedemo.functionalDemo;

import com.example.jeedemo.restclients.PersonalInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

  public static void main(String[] args) {
      PersonalInfo personalInfo = new PersonalInfo();
      personalInfo.setFullname("Shankar Ghimire");
      personalInfo.setAge(21);
      personalInfo.setEmail("coder.shankar@gmail.com");

      PersonalInfo personalInfo1 = new PersonalInfo();
      personalInfo1.setFullname("John snow");
      personalInfo1.setAge(26);
      personalInfo1.setEmail("jon-snow@got.com");

      List<PersonalInfo> personalInfoList = new ArrayList<>();
      personalInfoList.add(personalInfo);
      personalInfoList.add(personalInfo1);

      personalInfoList.stream().map(personalInfo2 -> personalInfo2.getFullname().toLowerCase()).forEach(System.out::println);



  }
}

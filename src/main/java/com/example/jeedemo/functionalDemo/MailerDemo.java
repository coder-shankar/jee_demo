package com.example.jeedemo.functionalDemo;

public class MailerDemo {
    public static void main(String[] args) {
        Mailer.send(MailerDemo::test);
    }

    private static void test(Mailer mailer) {
        mailer.setFrom("hello@gmail.com");
        mailer.to("hi@gmail.com");
    }
}

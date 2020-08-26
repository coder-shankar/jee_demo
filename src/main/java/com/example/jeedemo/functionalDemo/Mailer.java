package com.example.jeedemo.functionalDemo;

import lombok.Data;

import java.util.function.Consumer;

@Data
public class Mailer {

    private Mailer() {}

    private String from;
    private String to;

    public Mailer from(String from) {
        System.out.println("from = " + from);
        this.from = from;
        return this;
    }

    public Mailer to(String to) {
        System.out.println("to = " + to);
        this.to = to;
        return this;
    }

    public static void send(Consumer<Mailer> block) {
        Mailer mailer = new Mailer();
        block.accept(mailer);

        System.out.println("mailer.toString() = " + mailer.toString());
        System.out.println("\"sending message\" = " + "sending message");
    }

}

package com.kevin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PrettyPrintApple {

    public static void prettyPrintApple(List<Apple> list, ApplePredict predict) {

        for (Apple apple : list) {
            String test = predict.test(apple);
            System.out.println(test);
        }
    }

    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        list.add(new Apple("1", 1, "red"));
        list.add(new Apple("2", 2, "yellow"));
        prettyPrintApple(list, new ApplePredict() {
            @Override
            public String test(Apple apple) {
                return apple.getName() + apple.getColor();
            }
        });
        prettyPrintApple(list, (Apple apple) -> "####" + apple.getColor());
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread() + "   1");
            System.out.println(2);
            System.out.println(3);
        }, "thread1");

        int i = 18;
        Thread th = new Thread(() -> System.out.println(i));
        th.start();

        list.sort(Comparator.comparing(Apple::getWeight));

        thread.start();

    }
}

package com.kevin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 函数式接口测试
 */
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

        //传统方法--匿名内部类方法实现

        prettyPrintApple(list, new ApplePredict() {
            @Override
            public String test(Apple apple) {
                return apple.getName() + apple.getColor();
            }
        });

        //java8  lambda表达式实现
        prettyPrintApple(list, (Apple apple) -> "####" + apple.getColor());

        //其他常用函数式接口
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

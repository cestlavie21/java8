package com.kevin.StreamTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        List<String> list = menu.stream().filter((Dish d) -> d.getCalories() < 200).map(Dish::getName).collect(Collectors.toList());
        menu.stream().filter(d -> d.getCalories() > 500).forEach(System.out::println);
        System.out.println(list);

        Integer[] array = new Integer[]{1, 2, 3, 4, 5};

        Arrays.stream(array).map(i -> i * i).forEach(System.out::println);

        List<Integer> first = Arrays.asList(1, 2, 3);
        List<Integer> next = Arrays.asList(3, 4);

        List<int[]> collect = next.stream().flatMap(i -> next.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());

    }
}

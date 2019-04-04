package com.kevin.lambdaTest;

import com.kevin.lambdaTest.StreamTestDao.Dish;
import com.kevin.lambdaTest.StreamTestDao.Trader;
import com.kevin.lambdaTest.StreamTestDao.Transaction;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamTest {

    private List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    //Test Stream.filter 过滤筛选
    @Test
    public void filterTest() {
        //获取卡路里小于两百的dish
        List<String> list = menu.stream().filter((Dish d) -> d.getCalories() < 200).map(Dish::getName).collect(Collectors.toList());
        //获取卡路里大于300 且 是素食的dish
        menu.stream().filter(dish -> dish.getCalories() > 300 && dish.isVegetarian()).map(Dish::getName).forEach(System.out::println);
    }

    //Test Stream.map  映射流
    @Test
    public void mapTest() {
        //求数组中个元素平方

        Integer[] array = new Integer[]{1, 2, 3, 4, 5};

        Arrays.stream(array).map(i -> i * i).forEach(System.out::println);

        //flatmap  流的扁平化测试
        //将集合中的字符拆分为一个数组
        List<String> strings = Arrays.asList("java", "lambda", "map");
        List<String> flatString = strings.stream().map(s -> s.split("")).flatMap(Arrays::stream).collect(toList());
        System.out.println(flatString);

    }

    //Test  Stream.reduce  归并函数
    @Test
    public void reduceTest() {
        Integer[] arrays = {1, 2, 3, 4, 5};

        Integer sum = Arrays.stream(arrays).reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }

    //获取菜的总数  使用 map-reduce 模式
    @Test
    public void getTotalMeal() {
        Integer sum = menu.stream().map(d -> 1).reduce(0, Integer::sum);
        System.out.println(sum);
        //也可以使用count方法
        menu.stream().count();
    }

    //Stream 总练习
    @Test
    public void totalTest() {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        List<Transaction> list = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println(list);

        //  (2) 交易员都在哪些不同的城市工作过？
        List<String> cities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cities);

        //  (3) 查找所有来自于剑桥的交易员，并按姓名排序。
        List<String> strings = transactions.stream()
                .filter(t -> t.getTrader().getCity() == "Cambridge")
                .map(t -> t.getTrader().getName())
                .sorted()  //(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(strings);

        //  (4) 返回所有交易员的姓名字符串，按字母顺序排序。
        String nameString = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .reduce("", (s1, s2) -> s1 + s2);
        System.out.println(nameString);
        //  (5) 有没有交易员是在米兰工作的？
        boolean isMilan = transactions.stream()
                .anyMatch(t -> (t.getTrader().getCity() == "Milan"));
        System.out.println(isMilan);
        //  (6) 打印生活在剑桥的交易员的所有交易额。
        Integer sumValue = transactions.stream()
                .filter(t -> t.getTrader().getCity() == "Cambridge")
                .map(t -> t.getValue())
                .reduce(0, Integer::sum);
        System.out.println(sumValue);
        //  (7) 所有交易中，最高的交易额是多少？
        Integer max = transactions.stream()
                .map(t -> t.getValue())
                .reduce(0, Integer::max);
        System.out.println(max);
        //  (8) 找到交易额最小的交易。
        Optional<Integer> min = transactions.stream()
                .map(t -> t.getValue())
                .reduce(Integer::min);
        System.out.println(min.get());

    }

    // 数值流 mapToInt , mapToLong 测试
    @Test
    public void mapToIntTest() {
        int sum = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum);

        //输出1-100

    }

    //构建流 Stream.of
    @Test
    public void buildStreamTest() {
        Stream<String> a = Stream.of("a", "b", "c")
                .map(String::toUpperCase);
        a.forEach(System.out::println);

        //构建无限流  Stream.iterate()  Stream.generate()
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        List<Double> list = Stream.generate(Math::random).limit(10).collect(Collectors.toList());
        System.out.println(list);
    }

    // 流的归并，collect方法测试
    @Test
    public void StreamCollectTest() {
        //原始方式求和
        menu.stream().mapToInt(Dish::getCalories).sum();
        // collect 方式求和
        Integer sum = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(sum);

        //求平局值
        Double avgCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(avgCalories);

        //一次获取最大值，最小值，平均值,总数
        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(collect);

        //将字符串连接起来  join()
        String s = menu.stream().map(Dish::getName).collect(joining(","));
        System.out.println(s);

        //分组
        Map<Dish.Type, List<Dish>> typeMap = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(typeMap);

        Map<String, List<Dish>> collect1 = menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() > 700)
                return "high";
            else if (dish.getCalories() == 500)
                return "mid";
            else return "low";
        }));
        System.out.println(collect1);

        //二级分组  将另外的groupingby 传入
        Map<Dish.Type, Map<String, List<Dish>>> collect2 = menu.stream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
            if (dish.getCalories() > 700)
                return "high";
            else if (dish.getCalories() == 500)
                return "mid";
            else return "low";
        })));
        System.out.println(collect2);
    }

    //并行流 测试
    @Test
    public void parallelStreamTest() {
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L, 10000000).parallel().sum();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(sum);
    }

    //多重循环Test
}

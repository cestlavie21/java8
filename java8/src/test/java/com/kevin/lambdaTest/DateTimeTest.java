package com.kevin.lambdaTest;
import static java.time.temporal.TemporalAdjusters.*;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * java8 新的时间类测试
 */
public class DateTimeTest {


    @Test
    public  void  dateTimeTest(){

        System.out.println(LocalDateTime.now());
        System.out.println(Instant.now());


        //对时间进行加减和替换
        LocalDate date = LocalDate.of(2014, 3, 18);
        date = date.with(ChronoField.MONTH_OF_YEAR, 9);
        date = date.plusYears(2).minusDays(10);
        date.withYear(2011);
        System.out.println(date);

        //TemporalAdjuster  处理特殊的日期，例如当月的最后一天
        LocalDate lastDayOfMonth = LocalDate.now().with(lastDayOfMonth());
        System.out.println(lastDayOfMonth);


        //DateFormatter   格式化日期
        String formatISO = date.format(DateTimeFormatter.BASIC_ISO_DATE);

        System.out.println(formatISO);
        //自定义格式输出
        String format = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(format);

        //设置时区
        ZonedDateTime euroTime = LocalDateTime.now().atZone(ZoneId.of("Europe/Rome"));
        System.out.println(euroTime);
    }
}

package com.kevin.lambdaTest;

import com.kevin.lambdaTest.StreamTestDao.Trader;
import com.kevin.lambdaTest.StreamTestDao.Transaction;
import org.junit.Test;

import java.util.Optional;
import java.util.Properties;

public class OptionalTest {

    private Trader  trader = new Trader("1","2");
    private Transaction transaction = new Transaction(trader,1994,5000);

  private Properties props = new Properties();



    //optional测试
    @Test
    public  void optionalTest(){
        //将可能为空的值，用ofNullable 方法进行封装，返回一个optional<T> 对象
        Optional<Transaction> optTransaction = Optional.ofNullable(transaction);

        String s = optTransaction.map(Transaction::getTrader).map(Trader::getName).orElse("22");

        System.out.println(s);

        //optional filter方法测试
        optTransaction.filter(o -> o.getYear() <20).map(Transaction::getValue).ifPresent(System.out::println);

    }


    @Test
    public void readDuration(Properties props, String name){
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");


    }



}


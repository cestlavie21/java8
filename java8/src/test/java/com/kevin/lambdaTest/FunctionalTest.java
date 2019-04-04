package com.kevin.lambdaTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FunctionalTest {

    private List<Integer> list = new ArrayList<Integer>();


/*    给定一个列表List<value>，比如{1, 4,
            9}，构造一个List<List<Integer>>，它的成员都是类表{1, 4, 9}的子集——我们暂时不考虑
    元素的顺序。{1, 4, 9}的子集是{1, 4, 9}、{1, 4}、{1, 9}、{4, 9}、{1}、{4}、{9}以及{}。*/
    @Test
    public  void functionalTest(){
     list.add(1);
     list.add(4);
     list.add(9);



        System.out.println(list);

    }

public  List<List<Integer>>  getValue(ArrayList<Integer> list){

     if (list.isEmpty()){
         List<List<Integer>> ans = new ArrayList<>();
         ans.add(list);
         return ans;
     }
    Integer first = list.get(0);
    List<Integer> integers = list.subList(1, list.size());

    return null;
    }
}

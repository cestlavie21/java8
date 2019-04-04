package com.kevin;

/**
 * 函数式接口，将行为参数化，可以将函数作为值来传递
 */
@FunctionalInterface
public interface ApplePredict {
    String test(Apple apple);
}

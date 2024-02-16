package com.haixiang.pipeline.service;

@FunctionalInterface
public interface MyFunctionalInterface {
    void add();

    default void get() {

    }

    String toString();
}
package com.qcby.unifiedVerificationPlatform.controller;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Test<K, V> implements Map1<K, V> {


    @Override
    public Set<Entry1<K, V>> entryKey1() {
        System.out.println("map11111111111");
        return null;
    }

    @Data
    private static class Node<K, V> implements Entry1<K, V> {
        private int hehe;

        @Override
        public K setObject(K obj) {
            System.out.println("hehe: " + hehe);
            System.out.println("hahaha: " + obj);
            return obj;
        }
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public static void main(String[] args) {
        /*Test test = new Test();
        test.entryKey1();
        Test.Node node = new Test.Node<>();
        node.setHehe(2);
        Object obj = node.setObject(test);*/

        List list = new ArrayList();
        list.add(1);
        list.add(14);
        List list2 = new ArrayList(list);

        System.out.println(Integer.MAX_VALUE + 1 - MAX_ARRAY_SIZE < 0);
        System.out.println(Integer.MAX_VALUE + 1 < MAX_ARRAY_SIZE);
        System.out.println(MAX_ARRAY_SIZE - (Integer.MAX_VALUE + 1) < 0);
        System.out.println(MAX_ARRAY_SIZE < Integer.MAX_VALUE + 1);
        System.out.println(Integer.MAX_VALUE + 1 - (Integer.MAX_VALUE + 2) < 0);
        System.out.println(Integer.MAX_VALUE + 1 < Integer.MAX_VALUE + 2);
        int a=1;
        int b=a;
        a=2;
        System.out.println(b);

        StringBuilder sr = new StringBuilder();
        StringBuffer sf = new StringBuffer();
        String x="";
    }

}

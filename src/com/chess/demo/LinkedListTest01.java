package com.chess.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LinkedListTest01 {
    private static List<? super Number> list;
    public static void main(String[] args) {
        LinkedList<Object> linkedList = new LinkedList<>();
        list = linkedList;
        list.add(1);
        list.add(3.14);
        list.add(8);
        list.add(null);
        System.out.println(list);
        System.out.println(list.size());

        ((LinkedList<Object>)list).pollLast();
        System.out.println(list);
        System.out.println(list.size());
    }
}

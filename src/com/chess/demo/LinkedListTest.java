package com.chess.demo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: JZQ
 * @Date: 2023/11/24 10:43
 * @Description:
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        Iterator it = list.iterator();
        int readCount;
        while (it.hasNext()){
            System.out.println(it.next());
        }

        list.remove(1);
        System.out.println(list);

        list.set(1, 10);
        System.out.println(list);

        System.out.println(list.get(1));

//        if(list instanceof LinkedList){
//            LinkedList linkedList = (LinkedList) list;
//            linkedList.pollLast();
//        }

        ((LinkedList) list).pollLast();
        System.out.println(list);

        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add(1);
    }
}
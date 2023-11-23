package com.chess.demo;

/**
 * @Author: JZQ
 * @Date: 2023/11/8 11:57
 * @Description:
 */
public class Zi extends Fu{
    public static void main(String[] args) {
        Zi zi = new Zi();
        //System.out.println(zi.a); 私有的属性和方法无法继承
        System.out.println(zi.b); //0
        System.out.println(zi.c); //0
        System.out.println(zi.d); //0
    }
}

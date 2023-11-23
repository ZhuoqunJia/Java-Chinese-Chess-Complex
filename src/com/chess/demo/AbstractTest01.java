package com.chess.demo;

/**
 * @Author: JZQ
 * @Date: 2023/11/23 15:40
 * @Description:
 */
public abstract class AbstractTest01 {
    public AbstractTest01(){
        System.out.println("AbstractTest01");
    }

    public void m1(){
        System.out.println("实例方法");
    }

    public static void s1(){
        System.out.println("静态方法");
    }

    abstract void a1();
}

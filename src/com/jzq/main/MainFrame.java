package com.jzq.main;

/**
 * @Author: JZQ
 * @Date: 2023/11/8 10:34
 * @Description:
 */

import javax.swing.*;

/**
 *  类的定义格式：权限修饰符 类的关键字 类名 {}
 *      权限修饰符：4个
 *          private: 私有的
 *          默认: 缺省就是默认
 *          protected: 受保护的
 *          public: 公共的
 *      类的关键字：class
 *      类名：
 *          必须遵守命名规则
 *          建议遵守命名规范
 */
public class MainFrame {
    /**
     * main方法：
     *      格式是固定的
     *      是程序的入口，表示该类可以被执行，一个项目中可以存在多个类拥有main方法，但是一个类只能有一个main方法
     * @param args
     */
    public static void main(String[] args) {
        //创建了有一个名称为frame的JFrame实例对象，实例又称对象
        JFrame frame = new JFrame();
        //创建实例的格式：类名 实例名 = new 类的构造方法();
        //创建实例的格式：类名 实例名 = new 类名();
        //JFrame默认是一个看不见的窗口
        /**
         * 面向对象编程指的是：
         *     如何定义类
         *     如何去使用类中的属性和方法
         *         直接使用属性的情况非常少见，因为不安全
         *     如何区分属性和方法
         *         方法后面必须跟()，属性不用
         *     核心思想：就是如何定义更好的类，使用更方便
         */
        //设置窗口的大小
        frame.setSize(400,500);
        //设置窗口居中
        frame.setLocationRelativeTo(null);
        //设置点击关闭按钮同时结束JVM，每一个Java运行的程序都是一个JVM，是一个JVM进程
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //将游戏面板添加到窗口中
        frame.add(new GamePanel());
        //设置窗口可见，建议放在后面
        frame.setVisible(true);
    }
}

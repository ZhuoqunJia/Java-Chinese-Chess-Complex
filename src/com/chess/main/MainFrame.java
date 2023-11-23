package com.chess.main;

/**
 * @Author: JZQ
 * @Date: 2023/11/8 10:34
 * @Description:
 */

import javax.swing.*;

public class MainFrame {
    public static void main(String[] args) {
        //创建了有一个名称为frame的JFrame实例对象，实例又称对象
        JFrame frame = new JFrame();
        //创建实例的格式：类名 实例名 = new 类的构造方法();
        //创建实例的格式：类名 实例名 = new 类名();
        //JFrame默认是一个看不见的窗口
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

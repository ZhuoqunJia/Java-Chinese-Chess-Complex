package com.chess.main;

/**
 * @Author: JZQ
 * @Date: 2023/11/8 10:34
 * @Description:
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame implements ActionListener {
    public static void main(String[] args) {
        //创建了有一个名称为frame的JFrame实例对象，实例又称对象
        JFrame frame = new JFrame();
        //创建实例的格式：类名 实例名 = new 类的构造方法();
        //创建实例的格式：类名 实例名 = new 类名();
        //JFrame默认是一个看不见的窗口
        //设置窗口的大小
        frame.setSize(550,500);
        //设置窗口居中
        frame.setLocationRelativeTo(null);
        //设置点击关闭按钮同时结束JVM，每一个Java运行的程序都是一个JVM，是一个JVM进程
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置布局管理器
        frame.setLayout(new BorderLayout());
        //将游戏面板添加到窗口中
        frame.add(new GamePanel(), BorderLayout.CENTER);
//        System.out.println("==================");
        //添加按钮面板
        JPanel btnPanel = new JPanel(new GridLayout(4, 1));
        frame.add(btnPanel, BorderLayout.EAST);
        JLabel hintLabel = new JLabel("红方走");
        btnPanel.add(hintLabel);
        JButton btnHuiQi = new JButton("悔棋");
        btnPanel.add(btnHuiQi);
        JButton btnSave = new JButton("保存棋谱");
        btnPanel.add(btnSave);
        JButton btnImport = new JButton("导入棋谱");
        btnPanel.add(btnImport);
        JButton btnQiuHe = new JButton("求和");
        btnPanel.add(btnQiuHe);
        JButton btnRenShu = new JButton("认输");
        btnPanel.add(btnRenShu);
        //设置窗口可见，建议放在后面
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

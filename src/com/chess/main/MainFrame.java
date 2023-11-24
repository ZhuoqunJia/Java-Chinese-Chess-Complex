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

public class MainFrame extends JFrame implements ActionListener {

    public MainFrame(){
        //设置窗口的大小
        this.setSize(555,500);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置点击关闭按钮同时结束JVM，每一个Java运行的程序都是一个JVM，是一个JVM进程
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置布局管理器
        this.setLayout(new BorderLayout());
        //将游戏面板添加到窗口中
        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel, BorderLayout.CENTER);
//        System.out.println("==================");
        //添加按钮面板
        JPanel btnPanel = new JPanel(new GridLayout(4, 1));
        this.add(btnPanel, BorderLayout.EAST);
        JLabel hintLabel = new JLabel("红方走");
        btnPanel.add(hintLabel);
        gamePanel.setHintLabel(hintLabel);

        JButton btnHuiQi = new JButton("悔棋");
        btnHuiQi.setActionCommand("huiqi");
        btnHuiQi.addActionListener(MainFrame.this);
        btnPanel.add(btnHuiQi);

        JButton btnSave = new JButton("保存棋谱");
        btnSave.setActionCommand("baocun");
        btnSave.addActionListener(this);
        btnPanel.add(btnSave);

        JButton btnImport = new JButton("导入棋谱");
        btnImport.setActionCommand("daoru");
        btnImport.addActionListener(this);
        btnPanel.add(btnImport);

        JButton btnQiuHe = new JButton("求和");
        btnQiuHe.setActionCommand("qiuhe");
        btnQiuHe.addActionListener(this);
        btnPanel.add(btnQiuHe);

        JButton btnRenShu = new JButton("认输");
        btnRenShu.setActionCommand("renshu");
        btnRenShu.addActionListener(this);
        btnPanel.add(btnRenShu);

        //设置窗口可见，建议放在后面
        this.setVisible(true);
    }
    public static void main(String[] args) {
        //执行构造方法
        MainFrame mainFrame = new MainFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("按钮被点击了");
        String cmd = e.getActionCommand();
        switch (cmd){
            case "huiqi":
                System.out.println("huiqi");
                break;
            case "baocun":
                System.out.println("baocun");
                break;
            case "daoru":
                System.out.println("daoru");
                break;
            case "qiuhe":
                System.out.println("qiuhe");
                break;
            case "renshu":
                System.out.println("renshu");
                break;
        }
    }
}

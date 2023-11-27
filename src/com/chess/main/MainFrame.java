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
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainFrame extends JFrame implements ActionListener {

    private final GamePanel gamePanel;

    public MainFrame() {
        //设置窗口的大小
        this.setSize(555, 500);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置点击关闭按钮同时结束JVM，每一个Java运行的程序都是一个JVM，是一个JVM进程
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置布局管理器
        this.setLayout(new BorderLayout());
        //将游戏面板添加到窗口中
        this.gamePanel = new GamePanel();
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
        switch (cmd) {
            case "huiqi":
                System.out.println("huiqi");
                this.gamePanel.huiqi();
                break;
            case "baocun":
                System.out.println("baocun");
                this.save();
                break;
            case "daoru":
                System.out.println("daoru");
                this.daoru();
                break;
            case "qiuhe":
                System.out.println("qiuhe");
                break;
            case "renshu":
                System.out.println("renshu");
                break;
        }
    }

    /**
     * 导入棋谱
     */
    private void daoru() {
        JFileChooser chooser = new JFileChooser();
//        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(null);
        File parent = chooser.getSelectedFile();

        if (null != parent) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(parent))) {
                Object object = ois.readObject();
                System.out.println("获取的Chess数组对象为===" + object);
                if (object instanceof Chess[]) {
                    gamePanel.setChesses((Chess[]) object);
                }
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    /**
     * 保存棋谱
     */
    private void save() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(null);
        File parent = chooser.getSelectedFile();
        System.out.println("parent-->" + parent);
        if (null != parent) {
            //创建文件
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss-SSS");
            String path = parent.getAbsolutePath() + File.separator + simpleDateFormat.format(new Date(System.currentTimeMillis())) + ".txt";
            File file = new File(path);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            //创建对象字节输出流
            ObjectOutputStream oos = null;
            try {
                //处理流和节点流
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(gamePanel.getChesses());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } finally {
                if (null != oos) {
                    try {
                        oos.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        }
    }
}

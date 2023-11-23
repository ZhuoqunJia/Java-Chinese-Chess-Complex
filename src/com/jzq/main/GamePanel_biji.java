package com.jzq.main;

/**
 * @Author: JZQ
 * @Date: 2023/11/8 11:37
 * @Description:
 */

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;

/**
 * 在swing编程中面板是指JPanel这个类
 *     在JFrame自带有一个面板，但那个面板有bug
 * 关于java的继承
 *     格式：
 *         public class 子类名 extends 父类名
 *     注意：
 *         1、子类是必须先存在的
 *         2、子类只能继承父类中的非私有（private）修饰的属性和方法
 *         3、父类中私有的属性和方法不能被子类继承
 *     方法重写：只针对于实例方法，不针对实例变量
 *         1、子类重新定义父类中的同名方法，必须一模一样
 *         2、重写方法不能比被重写方法限制有更严格的访问级别
 *         3、形参列表必须与被重写方法的相同
 *         4、返回类型必须与被重写方法的返回类型相同
 *         5、重写方法不能抛出新的异常或者比被重写方法声明的检查异常更广泛的检查异常
 *         6、不能重写被表示为final的方法
 *         7、如果一个方法不能被继承，则不能重写它，例如private 私有方法
 *         8、子类不能用 静态方法 重写父类的非静态方法
 *         9、子类不能用 非静态方法  重写  父类的静态方法
 *
 */
public class GamePanel_biji extends JPanel {
    @Override //重写注解
    //如果该方法是重写父类中的方法，加不加都不会报错
    //但是如不是重写父类中的中方法，加上就会报错
    public void paint(Graphics g) {
        //super.paint(g); //删除或注释即可
        /**
         * paint方法是JPanel类中绘制面板内容的实例方法
         * Graphics；绘制类，是一个抽象类
         * 常用实例方法：
         *     drawImage(): 画图片
         *     drawChars(): 画文字
         *     drawLine(): 画直线的
         *     drawOval(): 画圆或椭圆
         *
         * 如何在JPane画一张图
         *     1、准备图片路径
         *          File.separator: 路径分隔符
         *              Windows系统：\，反斜杠
         *              Linux和macos系统：/，斜杠
         *     2、通过图片路径得到图片对象
         *     3、使用g.drawImage()方法将图片绘制到面板上
         */
        //1、准备图片路径
        String backGroundPicture = "picture" + File.separator + "qipan.jpg";
        //System.out.println(backGroundPicture); //picture\qipan.jpg
        System.out.println("每拖动一次窗口，就会在画板上重新画一次");
        //2、通过图片路径得到图片对象
        /**
         * getDefaultToolkit(): Toolkit类中的静态方法，用于获取Toolkit类型的实例对象
         * 获取实例对象并不止通过new 的方式，还可以通过方法来获取实例对象
         *
         * Toolkit实例对象常用实例方法：
         *     createImage(): 创建图片
         *     getImage(): 获取图片
         */
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image bgImg = toolkit.getImage(backGroundPicture);
        //3、使用g.drawImage方法将图片绘制到面板上
        /**
         * boolean drawImage(Image img, int x, int y, ImageObserver observer)
         * img: 要绘制的图片对象
         * x: 坐标x，在编程中坐标都是从左上角开始的，到右下角，往右是正数
         * y: 坐标y，往下是正数
         * observer: 图片观察者，写JPanel对象即可，如上写this，表示就是当执行该行代码时的对象
         */
        g.drawImage(bgImg, 0, 0, this);


//        //如何画棋子
//        /**
//         * 画红棋：车
//         */
//        //1、准备图片路径
//        String che0Path = "picture" + File.separator + "che0.png";
//        //2、通过图片路径得到图片对象
//        Image che0Img = Toolkit.getDefaultToolkit().getImage(che0Path);
//        //3、使用g.drawImage方法将图片绘制到面板上
//        g.drawImage(che0Img, 5, 5, 30,30,this);
//
//        /**
//         * 画红棋：马
//         */
//        //1、准备图片路径
//        String ma0Path = "picture" + File.separator + "ma0.png";
//        //2、通过图片路径得到图片对象
//        Image ma0Img = Toolkit.getDefaultToolkit().getImage(ma0Path);
//        //3、使用g.drawImage方法将图片绘制到面板上
//        g.drawImage(ma0Img, 45, 5, 30,30,this);
//
//        /**
//         * 画红棋：象
//         */
//        String xiang0Path = "picture" + File.separator + "xiang0.png";
//        Image xiang0Image = Toolkit.getDefaultToolkit().getImage(xiang0Path);
//        g.drawImage(xiang0Image, 85, 5, 30,30,this);

        /**
         * 使用数组和循环来优化代码
         *     变量有一个局限性，就是只能保存一个数据
         *     如何保存多个数据？
         *         就需要使用到数组和集合
         *     数组的基本使用：
         *         1、如何定义，必须指定长度
         *             静态定义，必须是一行，即定义和赋值必须在一行
         *                  格式：
         *                      完整格式：
         *                          数据类型[] 数组名 = new 数据类型[]{值1, 值2, 值3, ...};
         *                      简写格式：
         *                          数据类型[] 数组名 = {值1, 值2, 值3}；
         *                          int[] ints = {1, 2, 3};
         *             动态定义，可以先定义，在赋值
         *                  格式：
         *                      数据类型[] 数组名 = new 数据类型[数组长度]；
         *                      int[] ints = new int[3];
         *                      先定义：数据类型[] 数组名 [= null];
         *                      后赋值：数组名 = new 数据类型[数组长度];
         *         2、数组的长度: length属性
         *         3、数组的索引
         *              从0开始，长度-1 结束  [0, length - 1]
         *              如果超出范围，会抛出异常，数组索引越界异常，java.lang.ArrayIndexOutBoundsException
         *         4、数组元素的使用及赋值
         *              格式：数组名[索引值] = 值;
         *              注意：数组在使用之前，一定要先初始化，即赋值，否则报空指针异常 java.lang.NullPointerException
         *         5、数组的异常
         *              数组索引越界异常：java.lang.ArrayIndexOutOfBoundException
         *              空指针异常：java.lang.NullPointerException
         *         6、数组的遍历，使用循环
         *              遍历就是指，从头到尾或反过来，从尾到头，一个个元素的过一遍
         */
        //定义了一个String类型的变量，变量名为path
//        String Path = "picture" + File.separator + "xiang0.png";
//        Image Image = Toolkit.getDefaultToolkit().getImage(Path);
//        g.drawImage(Image, 85, 5, 30,30,this);

        //定义字符创数组
        //String[] names = {"che0.png", "che0.png", "che0.png"};
//        String[] names = new String[3];
//        names[0] = "che0.png";
//        names[1] = "ma0.png";
//        String[] names = new String[]{"che", "ma", "xiang", "shi", "boss", "shi", "xiang", "ma", "che",
//                                        "pao", "pao",
//                                        "bing", "bing", "bing", "bing", "bing"};
//        //旗子的阵营
//        int player = 0;
//        //图片的后缀
//        String suffix = ".png";
//        //棋子的大小
//        int size = 30;
//        //棋盘的边距
//        int margin = 20;
//        //棋子之间间距
//        int space = 40;
//        int[] xs = {5, 45, 85, 125, 165, 205, 245, 285, 325, 45, 285, 5, 85, 165, 245, 325};
//        int[] ys = {5, 5, 5, 5, 5, 5, 5, 5, 5, 85, 85, 125, 125, 125, 125, 125};

//        int[] xs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 8, 1, 3, 5, 7, 9};
//        int[] ys = {1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 4, 4, 4, 4, 4};
//        for (int i = 0; i < names.length; i++) {
//            String Path = "picture" + File.separator + names[i] + player + suffix;
//            Image Image = Toolkit.getDefaultToolkit().getImage(Path);
//            g.drawImage(Image, (margin - size / 2) + space * (xs[i] - 1), (margin - size / 2) + space * (ys[i] - 1), size,size,this);
//        }
//
//        //画出黑色方棋子
//        player = 1;
//        for (int i = 0; i < names.length; i++) {
//            String Path = "picture" + File.separator + names[i] + player + suffix;
//            Image Image = Toolkit.getDefaultToolkit().getImage(Path);
//            g.drawImage(Image, (margin - size / 2) + space * (this.reverseX(xs[i]) - 1), (margin - size / 2) + space * (this.reverseY(ys[i]) - 1), size,size,this);
//        }

        String[] names = new String[]{"che", "ma", "xiang", "shi", "boss", "shi", "xiang", "ma", "che",
                                "pao", "pao",
                                "bing", "bing", "bing", "bing", "bing"};
        Point[] ps = {
                new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(4, 1), new Point(5, 1), new Point(6, 1), new Point(7, 1), new Point(8, 1), new Point(9, 1),
                new Point(2, 3), new Point(8, 3),
                new Point(1, 4), new Point(3, 4), new Point(5, 4), new Point(7, 4), new Point(9, 4)
        };

        for (int i = 0; i < ps.length; i++) {
            Chess c = new Chess(); //创建棋子对象
            c.setName(names[i]); //指定棋子名称
            c.setP(ps[i]); //指定棋子的网格坐标
            c.setPlayer(0); //这是棋子阵营
            c.draw(g, this); //绘制棋子
        }

        for (int i = 0; i < ps.length; i++) {
            Chess c = new Chess(); //创建棋子对象
            c.setName(names[i]); //指定棋子名称
            c.setP(ps[i]); //指定棋子的网格坐标
            c.reserve(); //反转网络坐标
            c.setPlayer(1); //这是棋子阵营
            c.draw(g, this); //绘制棋子
        }




    }

    /**
     * 反转x坐标方法
     * @param x
     * @return
     */
    private int reverseX(int x){
        return 10 - x;
    }

    /**
     * 反转y坐标方法
     * @param y
     * @return
     */
    private int reverseY(int y){
        return 11 - y;
    }

    public static void main(String[] args) {
//        String backGroundPicture = "picture" + File.separator + "qipan.jpg";
//        System.out.println(backGroundPicture);
//        System.out.println(111);

        String[] strings = new String[3];
        System.out.println(Arrays.toString(strings));
//        System.out.println(strings[3]);
        strings[0] = "j";
        strings[1] = "z";
        strings[2] = "q";

        for (String ele:
             strings) {
            System.out.println(ele);
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}

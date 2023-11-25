package com.chess.demo;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File file1 = new File("笔记/io流.txt");
        System.out.println(file1.exists()); //true
        File file2 = new File("C:\\Users\\13476\\Desktop\\java项目\\Java-Chinese-Chess-Complex\\笔记\\io流.txt");
        System.out.println(file2.exists()); //true
    }
}

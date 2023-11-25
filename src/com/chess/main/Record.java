package com.chess.main;

import java.awt.*;

/**
 * @Author: JZQ
 * @Date: 2023/11/24 11:18
 * @Description: 走棋记录类
 */
public class Record {
    //操作的棋子类
    private Chess chess;
    //起点坐标
    private Point start;
    //结束坐标
    private Point end;
    //被吃掉的棋子
    private Chess eatedChess;

    public Record() {
    }

    public Record(Chess chess, Point start, Point end, Chess eatedChess) {
        this.chess = chess;
        this.start = start;
        this.end = end;
        this.eatedChess = eatedChess;
    }

    public Record(Chess chess, Point start, Point end) {
        this.chess = chess;
        this.start = start;
        this.end = end;
    }

    public Chess getEatedChess() {
        return eatedChess;
    }

    public void setEatedChess(Chess eatedChess) {
        this.eatedChess = eatedChess;
    }

    public Chess getChess() {
        return chess;
    }

    public void setChess(Chess chess) {
        this.chess = chess;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Record{" +
                "chess=" + chess +
                ", start=" + start +
                ", end=" + end +
                ", eatedChess=" + eatedChess +
                '}';
    }
}

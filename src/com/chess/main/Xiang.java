package com.chess.main;

import java.awt.*;

/**
 * @Author: JZQ
 * @Date: 2023/11/23 16:15
 * @Description:
 */
public class Xiang extends Chess{
    public Xiang(int player, Point p) {
        super("xiang", player, p);
    }

    public Xiang(int player, int px) {
        this(player, new Point(px, 1));
    }

    @Override
    public boolean isAbleMove(Point tp, GamePanel gamePanel) {
        return this.line(tp) == 1 && this.getStep(tp) == 2 && !this.isBieJiao(tp, gamePanel) && !this.isOverRiver(tp);
    }
}

package com.chess.main;

import java.awt.*;

/**
 * @Author: JZQ
 * @Date: 2023/11/23 16:15
 * @Description:
 */
public class Ma extends Chess{
    public Ma(int player, Point p) {
        super("ma", player, p);
    }

    public Ma(int player, int px) {
        this(player, new Point(px, 1));
    }

    @Override
    public boolean isAbleMove(Point tp, GamePanel gamePanel) {
        return (this.line(tp) == -1 || this.line(tp) == 0) && !this.isBieJiao(tp, gamePanel);
    }
}

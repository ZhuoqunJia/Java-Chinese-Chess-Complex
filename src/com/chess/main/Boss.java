package com.chess.main;

import java.awt.*;

/**
 * @Author: JZQ
 * @Date: 2023/11/23 16:15
 * @Description:
 */
public class Boss extends Chess{
    public Boss(int player, Point p) {
        super("boss", player, p);
    }

    public Boss(int player, int px) {
        this(player, new Point(px, 1));
    }

    @Override
    public boolean isAbleMove(Point tp, GamePanel gamePanel) {
        return this.isHome(tp) && this.line(tp) > 1 && this.getStep(tp) == 1;
    }
}

package com.chess.main;

import java.awt.*;

/**
 * @Author: JZQ
 * @Date: 2023/11/23 16:15
 * @Description:
 */
public class Che extends Chess{
    public Che(int player, Point p) {
        super("che", player, p);
    }

    public Che(int player, int px) {
        this(player, new Point(px, 1));
    }

    @Override
    public boolean isAbleMove(Point tp, GamePanel gamePanel) {
        return this.line(tp) > 1 && this.getCountFromOriginToTarget(tp, gamePanel) == 0;
    }
}

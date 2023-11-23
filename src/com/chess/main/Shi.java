package com.chess.main;

import java.awt.*;

/**
 * @Author: JZQ
 * @Date: 2023/11/23 16:15
 * @Description:
 */
public class Shi extends Chess{
    public Shi(int player, Point p) {
        super("shi", player, p);
    }

    public Shi(int player, int px) {
        this(player, new Point(px, 1));
    }

    @Override
    public boolean isAbleMove(Point tp, GamePanel gamePanel) {
        return isHome(tp) && line(tp) == 1 && getStep(tp) == 1;
    }
}

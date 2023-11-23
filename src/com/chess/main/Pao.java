package com.chess.main;

import java.awt.*;

/**
 * @Author: JZQ
 * @Date: 2023/11/23 16:15
 * @Description:
 */
public class Pao extends Chess{
    public Pao(int player, Point p) {
        super("pao", player, p);
    }

    public Pao(int player, int px) {
        this(player, new Point(px, 3));
    }

    @Override
    public boolean isAbleMove(Point tp, GamePanel gamePanel) {
        Chess c = gamePanel.getChessByP(tp);
        if(null != c){
//            if(c.getPlayer() != this.player) {
                //吃子
                return this.line(tp) > 1 && this.getCountFromOriginToTarget(tp, gamePanel) == 1;
//            }
        }else {
            //移动
            return this.line(tp) > 1 && this.getCountFromOriginToTarget(tp, gamePanel) == 0;
        }
    }
}

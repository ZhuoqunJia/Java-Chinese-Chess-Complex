package com.chess.main;

import java.awt.*;

/**
 * @Author: JZQ
 * @Date: 2023/11/23 16:15
 * @Description:
 */
public class Bing extends Chess{
    public Bing(int player, Point p) {
        super("bing", player, p);
    }

    public Bing(int player, int px) {
        this(player, new Point(px, 4));
    }

    @Override
    public boolean isAbleMove(Point tp, GamePanel gamePanel) {
        //兵移动规则：不能后退，只能走直线，只能走一步
        if(this.line(tp) < 2 || this.getStep(tp) != 1 || this.isBack(tp)){
            return false;
        }
        //没过河只能前进，过了河既可以前进也可以左右走
        boolean overRiver = this.isOverRiver(this.p);
        if(overRiver){
            return this.line(tp) > 1;
        }else {
            return this.line(tp) == 2;
        }
    }
}

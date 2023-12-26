package com.example;

import com.example.Obj.BodyObj;
import com.example.Obj.FoodObj;
import com.example.Obj.HeadObj;
import com.example.Utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameWin extends JFrame {
    //分数
    public static int score = 0;
    //窗口宽高
    int winWidth = 800;
    int winHeight = 600;
    //蛇头对象
    HeadObj headObj = new HeadObj(GameUtils.right, 30,570, this);

    //蛇身集合
    public List<BodyObj> bodyObjList = new ArrayList<>();
    //食物
    public FoodObj foodObj = new FoodObj().getFood();

    public void launch() {
        //窗口是否可见
        this.setVisible(true);
        //窗口大小
        this.setSize(winWidth, winHeight);
        //窗口在屏幕居中
        this.setLocationRelativeTo(null);
        //窗口标题
        this.setTitle("Snake Game");
        //蛇身初始化
        bodyObjList.add(new BodyObj(GameUtils.body, 30, 570, this));
        bodyObjList.add(new BodyObj(GameUtils.body, 0, 570, this));
        while (true){
            repaint();
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        //灰色背景
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,winWidth,winHeight);
        //网格
        g.setColor(Color.BLACK);
        for (int i = 0; i < 20; i++) {
            //横线
            g.drawLine(0,i*30,600,i*30);
            //竖线
            g.drawLine(i*30,0,i*30,600);
        }
        //绘制身体
        for (int i = bodyObjList.size() -1; i>=0; i--) {
            bodyObjList.get(i).paintSelf(g);
        }
        //绘制蛇头
        headObj.paintSelf(g);
        //食物绘制
        foodObj.paintSelf(g);
        //绘制分数
        GameUtils.drawWord(g, "Score:" + score, Color.BLUE, 30, 650, 300);
    }

    public static void main(String[] args){
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}

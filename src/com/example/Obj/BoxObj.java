package com.example.Obj;

import com.example.GameWindow;
import com.example.Utils.GameUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FoodObj extends GameObj{
    //随机
    Random r = new Random();
    public FoodObj() {
        super();
    }


    public FoodObj(Image img, int x, int y, GameWindow frame) {
        super(img, x, y, frame);
    }

    //获取食物
    public FoodObj getFood(){
      return new FoodObj(GameUtils.food, r.nextInt(20)*30, (r.nextInt(19)+1)*30, this.frame);
    };

    public List<FoodObj>generatedFood(int count){
        List<FoodObj> foodObjs = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            foodObjs.add(getFood());
        }
        return foodObjs;
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
    }
}

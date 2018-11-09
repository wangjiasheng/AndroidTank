package com.wjs.mtank;

import android.graphics.Canvas;
import android.util.Log;

import com.wjs.androidtank.Spirit;

import java.util.Random;

public class BaseTank implements Spirit {
    public static final int TANK_WIDTH=100;     //坦克的宽度
    public static final int TANK_HIEGHT=100;    //坦克的高度
    public static final int TANK_SPEED =40;       //坦克的移动速度
    public int locationX=TANK_WIDTH/2;          //坦克X方向的位置
    public int locationY=TANK_HIEGHT/2;         //坦克Y方向的位置
    public Direction direction=Direction.LEFT;            //坦克的方向
    public enum Direction{
        LEFT(1,"LEFT"),TOP(2,"TOP"),RIGHT(3,"RIGHT"),BOTTOM(4,"BOTTOM");
        private int id;
        private String method;
        Direction(int id,String method){
            this.id=id;
            this.method=method;
        }

        public int getId() {
            return id;
        }

        public String getMethod() {
            return method;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setMethod(String method) {
            this.method = method;
        }
    }
    @Override
    public void draw(Canvas canvas) {
        move(canvas.getWidth(),canvas.getHeight());
        autoDrection();
        mastDrection(canvas.getWidth(),canvas.getHeight());
    }
    /**
     * 随机一个不等于one的方向
     * @param one
     */
    public void randomDirection(int one) {
        int value=0;
        do {
            value= new Random().nextInt(4)+1;
        }while (value==one);
        switch (value){
            case 1:
                direction = Direction.LEFT;
                break;
            case 2:
                direction = Direction.TOP;
                break;
            case 3:
                direction = Direction.RIGHT;
                break;
            case 4:
                direction = Direction.BOTTOM;
                break;
            default:
                direction = Direction.RIGHT;
                break;
        }
    }

    /**
     * 随机一个不等于one和two的方向
     * @param one
     * @param two
     */
    public void randomDirection(int one,int two) {
        int value=0;
        do {
            value= new Random().nextInt(4)+1;
        }while (value==one||value==two);
        switch (value){
            case 1:
                direction = Direction.LEFT;
                break;
            case 2:
                direction = Direction.TOP;
                break;
            case 3:
                direction = Direction.RIGHT;
                break;
            case 4:
                direction = Direction.BOTTOM;
                break;
            default:
                direction = Direction.RIGHT;
                break;
        }
    }
    /**
     * 坦克移动
     */
    public void move(int width,int height){
        switch (direction){
            case RIGHT:
                locationX+= TANK_SPEED;
                break;
            case LEFT:
                locationX-= TANK_SPEED;
                break;
            case TOP:
                locationY-= TANK_SPEED;
                break;
            case BOTTOM:
                locationY+= TANK_SPEED;
                break;
        }
    }

    /**
     * 坦克不得不变换方向的时候调用
     * @param width
     * @param height
     */
    public void mastDrection(int width,int height){
        boolean run_right=locationX>=width-TANK_WIDTH/2;   //跑到屏幕右边
        boolean run_left=locationX<=TANK_WIDTH/2;          //跑到屏幕左边
        boolean run_top=locationY<=TANK_HIEGHT/2;          //跑到屏幕上边
        boolean run_bottom=locationY>=height-TANK_HIEGHT/2;//跑到屏幕右边
        if(run_right&&run_top){
            locationX=width-TANK_WIDTH/2;
            locationY=TANK_HIEGHT/2;
            randomDirection(Direction.RIGHT.getId(),Direction.TOP.getId());
        }
        else if (run_left&&run_top){
            locationX=TANK_WIDTH/2;
            locationY=TANK_HIEGHT/2;
            randomDirection(Direction.LEFT.getId(),Direction.TOP.getId());
        }
        else if (run_left&&run_bottom) {
            locationX=TANK_WIDTH/2;
            locationY=height-TANK_HIEGHT/2;
            randomDirection(Direction.BOTTOM.getId(),Direction.LEFT.getId());
        }
        else if(run_right&&run_bottom){
            locationX=width-TANK_WIDTH/2;
            locationY=height-TANK_HIEGHT/2;
            randomDirection(Direction.BOTTOM.getId(),Direction.RIGHT.getId());
        }
        else if(run_left){
            locationX=TANK_WIDTH/2;
            randomDirection(Direction.LEFT.getId());
        }
        else if(run_right){
            locationX=width-TANK_WIDTH/2;
            randomDirection(Direction.RIGHT.getId());
        }
        else if(run_top){
            locationY=TANK_HIEGHT/2;
            randomDirection(Direction.TOP.getId());
        }
        else if(run_bottom){
            locationY=height-TANK_HIEGHT/2;
            randomDirection(Direction.BOTTOM.getId());
        }
        else{
            Log.i("wjs_wjs","wjsjwssssssssssssssss");
        }
    }
    /*
     *坦克随机变换方向
     */
    public void autoDrection(){
        int random=new Random().nextInt(20);
        switch (random){
            case 1:
                direction = Direction.LEFT;
                break;
            case 2:
                direction = Direction.TOP;
                break;
            case 3:
                direction = Direction.RIGHT;
                break;
            case 4:
                direction = Direction.BOTTOM;
                break;
        }
    }
}

package com.wjs.mtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class CircleTank extends BaseTank{
    /**
     * 绘制坦克的炮筒
     * @param canvas
     */
    private void drawPT(Canvas canvas){
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(3);
        switch (direction){
            case TOP:
                canvas.drawLine(locationX,locationY,locationX,locationY-TANK_HIEGHT,paint);
                break;
            case LEFT:
                canvas.drawLine(locationX,locationY,locationX-TANK_WIDTH,locationY,paint);
                break;
            case RIGHT:
                canvas.drawLine(locationX,locationY,TANK_WIDTH+locationX,locationY,paint);
                break;
            case BOTTOM:
                canvas.drawLine(locationX,locationY,locationX,locationY+TANK_HIEGHT,paint);
                break;
        }
    }

    /**
     * 绘制坦克的机身
     * @param canvas
     */
    public void drawTank(Canvas canvas){
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(locationX,locationY,TANK_WIDTH/2,paint);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawTank(canvas);
        drawPT(canvas);
    }
}

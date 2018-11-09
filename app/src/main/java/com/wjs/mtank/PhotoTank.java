package com.wjs.mtank;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.wjs.androidtank.R;

public class PhotoTank extends BaseTank {
    public Bitmap mTankTop;
    public Bitmap mTankRight;
    public Bitmap mTankBottom;
    public Bitmap mTankLeft;
    public PhotoTank(Context context){
        Bitmap mTankImg=BitmapFactory.decodeResource(context.getResources(),R.mipmap.mytank);
        mTankTop=resizeImage(mTankImg,0,TANK_WIDTH,TANK_HIEGHT);
        mTankRight=resizeImage(mTankImg,90,TANK_WIDTH,TANK_HIEGHT);
        mTankBottom=resizeImage(mTankImg,180,TANK_WIDTH,TANK_HIEGHT);
        mTankLeft=resizeImage(mTankImg,270,TANK_WIDTH,TANK_HIEGHT);
        mTankImg.recycle();
    }
    public static Bitmap resizeImage(Bitmap bitmap,int rotate, int w, int h)
    {
        Bitmap BitmapOrg = bitmap;
        int width = BitmapOrg.getWidth();
        int height = BitmapOrg.getHeight();
        int newWidth = w;
        int newHeight = h;

        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        Matrix matrix = new Matrix();
        matrix.postRotate(rotate);
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(BitmapOrg, 0, 0, width,
                height, matrix, true);
        return resizedBitmap;
    }
    public void drawTankIcon(Canvas canvas){
        Paint paint=new Paint();
        switch (direction){
            case TOP:
                canvas.drawBitmap(mTankTop,locationX-TANK_WIDTH/2,locationY-TANK_HIEGHT/2,paint);
                break;
            case LEFT:
                canvas.drawBitmap(mTankLeft,locationX-TANK_WIDTH/2,locationY-TANK_HIEGHT/2,paint);
                break;
            case RIGHT:
                canvas.drawBitmap(mTankRight,locationX-TANK_WIDTH/2,locationY-TANK_HIEGHT/2,paint);
                break;
            case BOTTOM:
                canvas.drawBitmap(mTankBottom,locationX-TANK_WIDTH/2,locationY-TANK_HIEGHT/2,paint);
                break;
        }
    }
    /**
     * 坦克的入口函数
     * @param canvas
     */
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawTankIcon(canvas);
    }
}

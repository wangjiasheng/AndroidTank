package com.wjs.androidtank;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;

public class GameStage  extends SurfaceView implements SurfaceHolder.Callback,Runnable {
    private SurfaceHolder mHolder;
    private Canvas mCanvas;
    private boolean mIsDrawing;
    private List<Spirit> list=new ArrayList<Spirit>();
    public GameStage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }
    public void initView(){
        mHolder=getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setKeepScreenOn(true);
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing=true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing=false;
    }

    @Override
    public void run() {
        while (mIsDrawing){
            draw();
        }
    }
    public void draw(){
        try {
            while(true) {
                mCanvas = mHolder.lockCanvas(null);
                doubleDraw(mCanvas);
                mHolder.unlockCanvasAndPost(mCanvas);
                Thread.sleep(160);
            }
        }catch (Exception e){

        }
        finally {
            if(mCanvas!=null){
                mHolder.unlockCanvasAndPost(mCanvas);
                mHolder=null;
                mCanvas=null;
            }
        }
    }
    public void doubleDraw(Canvas canvas){
        if(true) {
            Bitmap bitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas bitmapCanvas = new Canvas(bitmap);
            drawGAME(bitmapCanvas);
            canvas.drawBitmap(bitmap, 0, 0, null);
            if (bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }else{
            drawGAME(canvas);
        }
    }
    public void drawGAME(Canvas canvas){
        canvas.drawColor(Color.BLACK);
        for (Spirit spirit : list) {
            spirit.draw(canvas);
        }
    }
    public void addSpirit(Spirit spirit){
        list.add(spirit);
    }
}

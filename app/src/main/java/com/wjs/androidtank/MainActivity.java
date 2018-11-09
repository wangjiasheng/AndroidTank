package com.wjs.androidtank;

import android.app.Activity;
import android.os.Bundle;

import com.wjs.mtank.CircleTank;
import com.wjs.mtank.PhotoTank;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameStage mSurfaceView=findViewById(R.id.mSurfaceView);
        mSurfaceView.addSpirit(new PhotoTank(this));
        mSurfaceView.addSpirit(new CircleTank());
    }
}

package com.example.admin215.gamesurface;

import android.app.Activity;

import android.os.Bundle;

public class MainActivity extends Activity {
    public static final String TAG = "tag";
    MySurfaceView mySurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mySurfaceView = new  MySurfaceView(this);
        setContentView(mySurfaceView);
        int dd = getIntent().getIntExtra(TAG,20);
        mySurfaceView.sprites.setX(dd);
        mySurfaceView.sprites.setY(dd);

    }
}

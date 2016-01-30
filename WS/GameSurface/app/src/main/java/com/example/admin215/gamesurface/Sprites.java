package com.example.admin215.gamesurface;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Sprites {
    MySurfaceView mySurfaceView;

    int x = 20;
    int y = 20;


    Bitmap image;
    Paint paint = new Paint();

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    int widht, height;
    float speedX, speedY;
    final int IMAGE_ROWS = 4;
    final int IMAGE_COLUMNS = 3;
    int currentFrame = 0;
    int direction = 1;


    public Sprites(MySurfaceView surfaceView, Bitmap bitmap) {
        mySurfaceView = surfaceView;
        this.image = bitmap;
        widht = this.image.getWidth() / IMAGE_COLUMNS;
        height = this.image.getHeight() / IMAGE_ROWS;
    }

    public int nap(float ex, float ey) {

        speedX = ex;
        speedY = ey;
        float tng;
        tng = ex * ey;

        int naprav;
        if (tng > 0) {
            if (ex > 0) {
                naprav = 0;
                return naprav;

            }
            if (ex < 0) {
                naprav = 2;

                return naprav;

            }
        }
        if (tng <= 0) {
            if (ex > 0) {
                naprav = 3;

                return naprav;

            }
            if (ex < 0) {
                naprav = 1;

                return naprav;

            }
        }
        return  3;
    }








    public void controlRoute(){
        if(x<=0||x>=mySurfaceView.getWidth()-image.getWidth())
            speedX=-speedX;
        if(y<=0||y>=mySurfaceView.getHeight()-image.getHeight())
            speedY=-speedY;
        x+=speedX;
        y+=speedY;
        currentFrame =++currentFrame%IMAGE_COLUMNS;
        direction = nap(speedX,speedY);




    }
    public void setSpeed(float sX,float sY){
        speedX=sX;
        speedY=sY;
    }
    public void draw(Canvas canvas){
        controlRoute();
        Rect src=new Rect(currentFrame*widht,direction*height,currentFrame*widht+widht,direction*height+height);
        Rect dst=new Rect(x,y,x+widht,y+height);
        canvas.drawBitmap(image,src,dst,paint);
    }


}

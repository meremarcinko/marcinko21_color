package com.example.marcinko21.marcinko21_color;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;


public class FaceCircle extends CustomElement
{
    protected int x; //x-coordinate
    protected int y; //y-coordinate
    protected int size = 20;
    protected Paint myPaint;

    public FaceCircle(String name, int color)
    {
        super(name, color);

        // place a spot in a random location
        x = (int) (Math.random() * 1500) + 5;
        y = (int) (Math.random() * 1500) + 5;
        setRandomPaint();

    }

    //gives the shape a random color
    protected void setRandomPaint()
    {
        int color = Color.rgb((int) (Math.random() * 256),
            (int) (Math.random() *256),
            (int) (Math.random() * 256));
        myPaint = new Paint();
        myPaint.setColor(color);
    }

    public void drawFaceCircle(Canvas canvas)
    {
        canvas.drawCircle(x, y, size, myPaint);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public drawHighlight()
    {
        return;
    }
}

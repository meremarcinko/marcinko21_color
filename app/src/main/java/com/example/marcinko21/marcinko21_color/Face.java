package com.example.marcinko21.marcinko21_color;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;
import java.util.ArrayList;

/**
 * <!-- class Face -->
 *
 *This is the class that draws all the shapes and handles the surfaceview.
 *
 * @author Meredith Marcinko
 * @version Spring 2019
 *
 */
public class Face extends SurfaceView
{

    private CustomCircle faceCircle;
    private CustomCircle rightEye;
    private CustomCircle leftEye;
    private CustomCircle mouth;
    private CustomRect boxHat;
    private CustomRect baseHat;

    /**
     * External Citation
     * Date: February 17, 2019
     * Problem: I did not know the hexadecimals for the colors, nor did I know what
     * colors to use
     * Resources:
     * I looked up online a hexidecimal converter.
     * Solution:
     * https://www.rapidtables.com/web/color/RGB_Color.html
     */
    ArrayList<CustomElement> shapeList;

    public Face(Context context)
    {
        super(context);
    }

    public Face(Context context, AttributeSet set)
    {
        super(context, set);
        init();
    }

    /**
     * External Citation
     * Date: February 16, 2019
     * Problem: I was having trouble with the array and how to group all
     * the shapes to draw them
     * Resources:
     * Patrick Bellosil
     * Solution:
     * He suggested I use an arrayList
     */
    private void init()
    {
        setWillNotDraw(false);

        shapeList = new ArrayList<CustomElement>();

        //initializing the circles
        faceCircle = new CustomCircle("face", 0xFFFFA500, 500, 300, 200);
        shapeList.add(faceCircle);

        rightEye = new CustomCircle("right eye", 0xFFFF0000, 400, 280,40);
        shapeList.add(rightEye);

        leftEye = new CustomCircle("left eye", 0xFFFF0000, 600, 280, 40);
        shapeList.add(leftEye);

        mouth = new CustomCircle("mouth", 0xFFCCCCFF, 500, 375, 50);
        shapeList.add(mouth);


        //initializing the rectangles
        boxHat = new CustomRect("Box part of the Hat", 0xFF00FF00, 400,20,625, 120);
        shapeList.add(boxHat);

        baseHat = new CustomRect("rectangle part of the Hat", 0xFF00FF00, 250,100,700,200);
        shapeList.add(baseHat);
    }

    /** This method draws all the shapes*/
    protected void onDraw(Canvas canvas)
    {
        canvas.drawColor(0xFFFFFFF);

        //drawing the shapes
        for(CustomElement i : shapeList)
        {
            i.drawMe(canvas);
        }
    }

    /**
     * External Citation
     * Date: February 17, 2019
     * Problem: I did not
     * Resources:
     * I looked up online a hexidecimal converter.
     * Solution:
     * https://www.rapidtables.com/web/color/RGB_Color.html
     */

    /**
     * This method finds the shape on the screen through the tapping. It looks
     * for the x and y coordinates of the screen
     */
    public CustomElement findShape(int x, int y)
    {
        if(rightEye.containsPoint(x,y) == true)
        {
            return rightEye;
        }

        if(leftEye.containsPoint(x,y) == true)
        {
            return leftEye;
        }

        if(mouth.containsPoint(x,y) == true)
        {
            return mouth;
        }
        if(boxHat.containsPoint(x,y) == true)
        {
            return boxHat;
        }
        if(baseHat.containsPoint(x,y) == true)
        {
            return baseHat;
        }
        if(faceCircle.containsPoint(x,y) == true)
        {
            return faceCircle;
        }
        return null;
    }


}

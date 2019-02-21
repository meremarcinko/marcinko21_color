package com.example.marcinko21.marcinko21_color;


import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;
import static android.graphics.Color.rgb;

/**
 * <!-- class Controller -->
 *
 * This is the class the handles all of the touch events for the project
 *
 * @author Meredith Marcinko
 * @version Spring 2019
 *
 */
public class Controller implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener
{
    private TextView selectShape;
    private TextView redValue;
    private TextView greenValue;
    private TextView blueValue;
    private SeekBar redSeekBar;
    private SeekBar blueSeekBar;
    private SeekBar greenSeekBar;

    private Face surfaceView;

    private CustomElement customShape = null;

    //for colors
    int red;
    int blue;
    int green;

    /**
     * this is the constructor for the controller class.
     */

    public Controller(TextView initShape, TextView initRedTV, TextView initBlueTV, TextView initGreenTV,
                      SeekBar initRedSB, SeekBar initBlueSB, SeekBar initGreenSB, Face sv)
    {
        surfaceView = sv;

        selectShape = initShape;
        redValue = initRedTV;
        blueValue = initBlueTV;
        greenValue = initGreenTV;
        redSeekBar = initRedSB;
        blueSeekBar = initBlueSB;
        greenSeekBar = initGreenSB;

        redSeekBar.setOnSeekBarChangeListener(this);
        blueSeekBar.setOnSeekBarChangeListener(this);
        greenSeekBar.setOnSeekBarChangeListener(this);

        surfaceView.setOnTouchListener(this);
    }

/**
 * External Citation
 * Date: February 19, 2019
 * Problem: I did not know how to get the colors of the seek bar to be the
 * RGB values
 * Resources:
 * I looked up the rgb method
 * Solution:
 * https://developer.android.com/reference/android/graphics/Color.html#red(int)
 */
    /**
     * this is the method that tracks the progress of the seek bars
     * and what color they are set to when the seek bar stops moving
     */

    @Override
    public void onProgressChanged(SeekBar seekBar, int progressChanged, boolean user)
    {
        if(user == true)
        {
            if (seekBar == redSeekBar) {
                if (customShape != null) {
                    red = progressChanged;
                    customShape.setColor(rgb(red, green, blue));
                    redValue.setText("" + progressChanged);
                }
            }

            if (seekBar == blueSeekBar) {
                if (customShape != null) {
                    blue = progressChanged;
                    customShape.setColor(rgb(red, green, blue));
                    blueValue.setText("" + progressChanged);
                }
            }

            if (seekBar == greenSeekBar) {
                if (customShape != null) {
                    green = progressChanged;
                    customShape.setColor(rgb(red, green, blue));
                    greenValue.setText("" + progressChanged);
                }
            }
            //forces the shapes to redraw
            surfaceView.invalidate();
        }
    }

    /**
     * this method works with the tapping of the objects on the screen.
     * It deals with moving the seek bar up and down.
     */

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        int xTouch = (int)event.getX();
        int yTouch = (int)event.getY();

        customShape = surfaceView.findShape(xTouch,yTouch);

        if(customShape == null)
        {
            selectShape.setText("No shape selected");
            return false;
        }

        //gets the color of each shape
        red = red(customShape.getColor());
        blue = blue(customShape.getColor());
        green = green(customShape.getColor());


        //set the name of the text box to the name of the shape
        selectShape.setText(customShape.getName());

        redValue.setText("" + red);
        redSeekBar.setProgress(red);

        blueValue.setText("" + blue);
        blueSeekBar.setProgress(blue);

        greenValue.setText("" + green);
        greenSeekBar.setProgress(green);


        return true;
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekbar)
    {
        //nothing here
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekbar)
    {
        //nothing here
    }
}

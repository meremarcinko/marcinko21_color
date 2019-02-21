package com.example.marcinko21.marcinko21_color;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private TextView selectShape = null;
    private TextView redValue = null;
    private TextView greenValue = null;
    private TextView blueValue = null;
    private SeekBar redSeekBar = null;
    private SeekBar blueSeekBar = null;
    private SeekBar greenSeekBar = null;
    private Face sv = null;

    Controller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the textview with the color values


        redValue = (TextView)findViewById(R.id.redVal);
        redValue.setText("0");

        blueValue = (TextView)findViewById(R.id.blueVal);
        blueValue.setText("0");

        greenValue = (TextView)findViewById(R.id.greenVal);
        greenValue.setText("0");


        //connect the seekbars to their listeners
        redSeekBar = findViewById(R.id.redSeekBar);

        blueSeekBar = findViewById(R.id.blueSeekBar);

        greenSeekBar = findViewById(R.id.greenSeekBar);

        sv = findViewById(R.id.surfaceView);

        selectShape = findViewById(R.id.object);


        controller = new Controller(selectShape, redValue, blueValue, greenValue, redSeekBar, blueSeekBar, greenSeekBar, sv );
    }

}

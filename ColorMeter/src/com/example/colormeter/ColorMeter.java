package com.example.colormeter;

import android.app.Activity;
import android.os.Bundle;

import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.util.Log;
import android.widget.EditText;

public class ColorMeter extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.GREEN));
        bar.setTitle("Colorstrip");
    }
    
    public void onColor(View view)
    {
      setColorStrip();
    }

    public void plusRed(View view)
    {
      EditText red = (EditText)findViewById(R.id.red_color);      
      int ired = Integer.parseInt(red.getText().toString()) + 10;
      red.setText("" + ired);
      setColorStrip();
    }
    public void minusRed(View view)
    {
      EditText red = (EditText)findViewById(R.id.red_color);      
      int ired = Integer.parseInt(red.getText().toString()) - 10;
      red.setText("" + ired);
      setColorStrip();
    }
    public void plusGreen(View view)
    {
      EditText green = (EditText)findViewById(R.id.green_color);      
      int igreen = Integer.parseInt(green.getText().toString()) + 10;
      green.setText("" + igreen);
      setColorStrip();
    }
    public void minusGreen(View view)
    {
      EditText green = (EditText)findViewById(R.id.green_color);      
      int igreen = Integer.parseInt(green.getText().toString()) - 10;
      green.setText("" + igreen);
      setColorStrip();
    }
    public void plusBlue(View view)
    {
      EditText blue = (EditText)findViewById(R.id.blue_color);      
      int iblue = Integer.parseInt(blue.getText().toString()) + 10;
      blue.setText("" + iblue);
      setColorStrip();
    }
    public void minusBlue(View view)
    {
      EditText blue = (EditText)findViewById(R.id.blue_color);      
      int iblue = Integer.parseInt(blue.getText().toString()) - 10;
      blue.setText("" + iblue);
      setColorStrip();
    }

    private void setColorStrip()
    {
      try
      {
        EditText red = (EditText)findViewById(R.id.red_color);      
        EditText green = (EditText)findViewById(R.id.green_color);      
        EditText blue = (EditText)findViewById(R.id.blue_color);      

        int ired = Integer.parseInt(red.getText().toString());
        
        int igreen = Integer.parseInt(green.getText().toString());
        int iblue = Integer.parseInt(blue.getText().toString());
      
        Log.d("Venky", "Red: " + Integer.toHexString(ired));
        Log.d("Venky", "Green: " + Integer.toHexString(igreen));
        Log.d("Venky", "Blue: " + Integer.toHexString(iblue));

        ired = ired << 16;
        igreen = igreen << 8;
        int col = 0xFF000000;
        col = col | ired;
        col = col | igreen;
        col = col | iblue; 
        Log.d("Venky", "Color: " + Integer.toHexString(col));
        ActionBar ab = getActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(col));
        ab.setDisplayShowTitleEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayShowTitleEnabled(true);
       
      }
      catch(NumberFormatException numex)
      {
        Log.d("Venky", "Caught exception");
      }
    } 
   
    
}

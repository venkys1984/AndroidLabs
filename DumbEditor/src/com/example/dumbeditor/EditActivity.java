package com.example.dumbeditor;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class EditActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("Venky", "onCreate()");
        if(savedInstanceState != null)
        {
          Log.d("Venky", "We have a valid bundle in onCreate()");
        }
    }
    
    public void onResume()
    {
      super.onResume();
      Log.d("Venky", "onResume()");
    }

    protected void onStart()
    {
      super.onStart();
      Log.d("Venky", "onStart()");
    }

    protected void onPause()
    {
      super.onPause();
      Log.d("Venky", "onPause()");
    }

    protected void onStop()
    {
      super.onStop();
      Log.d("Venky", "onStop()");
    }

    protected void onDestroy()
    {
      super.onDestroy();
      Log.d("Venky", "onDestroy()");
    }

    public void onSaveInstanceState(Bundle instanceData)
    {
      super.onSaveInstanceState(instanceData);
      //EditText et = (EditText)findViewById(R.id.etid);
      //instanceData.putString("mydata", et.getText().toString());
    }
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
      Log.d("Venky", "ononRestoreInstanceState()");
      super.onRestoreInstanceState(savedInstanceState);
    }
}

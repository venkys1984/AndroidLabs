package com.dummy.av;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
import java.io.File;
import android.widget.EditText;

public class av extends Activity
{
	private Button pick ;
	private final int PICKFILE_RESULT_CODE = 400;
	 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        pick = (Button) findViewById(R.id.pick_file);
        if(pick == null)
        {
		  Log.d("Venky", "pick is NULL");	
		}
		else
		{
			Log.d("Venky", "pick is not NULL");	
		}
        
         pick.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 // Perform action on click
                 Log.d("Venky", "Picking a file");
                 Intent intent = new Intent(Intent.ACTION_PICK);
                 intent.setType("video/*");
                 startActivityForResult(intent, PICKFILE_RESULT_CODE);
				 //startActivity(intent);
				 Log.d("Venky", "Proceeded...");
             }
         });
        
      }
      protected void onActivityResult(int reqCode, int resCode, Intent resIntent)
      {
	    switch(reqCode)
	    {
		  case PICKFILE_RESULT_CODE : 
		  {
			  final Uri videoUri = resIntent.getData();
			  
			  //This will be a content URI
			  //To get the details you can do something like: adb shell content query --uri "content://media/external/video/media"
			  //This will give you the details
			  //A useful adb command
			  
			  //Log.d("Venky", "URI is: " + videoUri.toURL());
			  
			  Log.d("Venky", "String is: " + resIntent.getDataString());
			  /*File f = new File(videoUri);
			  Log.d("Venky", "Abs path is: " + f.getAbsolutePath());*/
			  
			  //hard coding for now. Write a function to get absolute path from URI
			  String filePath = "/storage/sdcard1/Movies/kabira.mp4";
			  EditText et = (EditText)findViewById(R.id.file_path);
			  et.setText(filePath);
			  
			  break;  
		  }	
		}	  
	  }
	  
	  protected void onStart()
	  {
		super.onStart();
		Log.d("Venky", "In onStart");  
	  }

      protected void onRestart()
      {
		super.onRestart();
		Log.d("Venky", "In onRestart");  
	  }

      protected void onResume()
      {
		super.onResume();
		Log.d("Venky", "In onResume");  
	  }

      protected void onPause()
      {
		super.onPause();
		Log.d("Venky", "In onPause");  
	  }

      protected void onStop()
      {
		super.onStop();
		Log.d("Venky", "In onStop");  
	  }

      protected void onDestroy()
      {
		super.onDestroy();
		Log.d("Venky", "In onDestroy");  
	  }
	  
	  public void Transcode(View view) 
	  {
         EditText ed = (EditText)findViewById(R.id.file_path);
         String filePath = ed.getText().toString();
         Log.d("Venky", "Ready to transcode : " + filePath);
      }
      
      
      
		

}

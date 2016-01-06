package com.dummy.geoquiz;

import android.app.Activity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import android.widget.Toast;

import android.util.Log;
import android.content.Intent;


public class CheatActivity extends Activity
{
	private TextView tv;
	private Button b;
	
	@Override 
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cheat);
        setCheatStatus(false);
        tv = (TextView)findViewById(R.id.answer);
        b = (Button)findViewById(R.id.show);
        b.setOnClickListener( new View.OnClickListener()
        {
		   public void onClick(View v)	
		   {
			   Intent origin = getIntent();
			   boolean ans = origin.getBooleanExtra("CheatAnswer", true);
			   if(ans)
			   {
				  tv.setText("True");   
			   }
			   else
			   {
				   tv.setText("False");   
			   }
			   setCheatStatus(true);
		   }
		}
        
        );
                
    }
    
    private void setCheatStatus(boolean isCheat)
    {
	  Intent i = new Intent();
	  i.putExtra("CheatMonitor", isCheat);
	  setResult(RESULT_OK, i);	
	 
    }
}

package com.dummy.geoquiz;

import android.app.Activity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import android.widget.Toast;

import android.util.Log;
import android.content.Intent;
import com.dummy.geoquiz.CheatActivity;

import com.dummy.geoquiz.TrueFalse;


public class GeoActivity extends Activity
{
	
	private Button mTrueButton;
	private Button mFalseButton;
	private Toast t;
	
	
	private TrueFalse[] mQuestionBank = new TrueFalse[] {
											new TrueFalse(R.string.question_oceans, true),
											new TrueFalse(R.string.question_mideast, false),
											new TrueFalse(R.string.question_africa, false),
											new TrueFalse(R.string.question_americas, true),
											new TrueFalse(R.string.question_asia, true) };
											
	private int index = 0;
	private TextView tv;
	private Button nextButton;		
	private Button prevButton;	
	private Button cheatButton;
	
	private static final String KEY_INDEX = "index";			
	private boolean isCheat = false;
	
	
    /** Called when the activity is first created. */
    
    //~ public void onCreate(Bundle savedInstanceState)
    //~ {
		//~ super.onCreate(savedInstanceState);
		//~ setContentView(R.layout.main);
    //~ }
    
    @Override 
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Log.d("Venky", this.getPackageName());
        index = 0;
        
        if (savedInstanceState != null) 
        {
          index = savedInstanceState.getInt(KEY_INDEX, 0);
        }
        mTrueButton = (Button)findViewById(R.id.T);
        mFalseButton = (Button)findViewById(R.id.F);
        tv = (TextView)findViewById(R.id.qspace);
             
        nextButton = (Button)findViewById(R.id.next);
        prevButton = (Button)findViewById(R.id.prev);
        cheatButton = (Button)findViewById(R.id.cheat);
        
        tv.setText(getQuestionString());  
        
        cheatButton.setOnClickListener(new View.OnClickListener()
        {
			public void onClick(View v)
			{
			  Intent i = new Intent(GeoActivity.this, CheatActivity.class);
			  i.putExtra("CheatAnswer", mQuestionBank[index].getAnswer());
			  //startActivity(i);	
			  startActivityForResult(i,15);	
			  Log.d("Venky", "In cheat!");	
			}
		});
        
        mTrueButton.setOnClickListener(new View.OnClickListener()
           {
			   public void onClick (View v)
               {
	             Evaluate(true);
	  	       }
		   }
         );
         
         
        mFalseButton.setOnClickListener(new View.OnClickListener()
           {
			   public void onClick (View v)
               {
	             Evaluate(false);
	  	
               }
		   }
         );
         
         nextButton.setOnClickListener(new View.OnClickListener()
                   {
					   public void onClick(View v)
					   {
					      index = (index + 1)%(mQuestionBank.length);
					      tv.setText(getQuestionString()); 
					   }
			  
		           }
          
          );
         
          prevButton.setOnClickListener(new View.OnClickListener()
                   {
					   public void onClick(View v)
					   {
					      if(index != 0)
					      {
					        index = (index - 1)%(mQuestionBank.length);
					      }
					      else
					      {
							  index = (mQuestionBank.length) -1;
						  }
					      tv.setText(getQuestionString()); 
					   }
			  
		           }
          
          );
         
          tv.setOnClickListener(new View.OnClickListener()
                   {
					   public void onClick(View v)
					   {
					      index = (index + 1)%(mQuestionBank.length);
					      tv.setText(getQuestionString());  	   
					   }
			  
		           }
          
          );
         
    }
    
    private String getQuestionString()
    {
		return getResources().getString(mQuestionBank[index].getQuestion());
	}
	
	private void Evaluate(boolean ans)
	{
		if(isCheat == true)
		{
			Toast.makeText(GeoActivity.this, R.string.Bar , Toast.LENGTH_LONG).show();
		}
		else if(mQuestionBank[index].getAnswer() == ans)
		{
		   //correct answer	
		   Toast.makeText(GeoActivity.this, R.string.Correct , Toast.LENGTH_LONG).show();
	    }
	    else
	    {
		  //wrong answer	
		  Toast.makeText(GeoActivity.this, R.string.Wrong , Toast.LENGTH_LONG).show();
	    }
	}
	
	protected void onSaveInstanceState(Bundle savedInstanceState)
	{
		super.onSaveInstanceState(savedInstanceState);
		//Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, index);
		
	}
	
	public void onDestroy()
	{
	  super.onDestroy();	
	  Log.d("Venky", "Activity destroyed");	
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent ret)
    {
	  Log.d("Venky" , "RequestCode is : " + Integer.toString(requestCode));
	  isCheat = ret.getBooleanExtra("CheatMonitor",false);
	  
	}
    
    
    
    
}

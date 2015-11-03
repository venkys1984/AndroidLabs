package com.dummy.geoquiz;

import android.app.Activity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import android.widget.Toast;

import com.dummy.geoquiz.TrueFalse;

//The main class
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
        index = 0;
        mTrueButton = (Button)findViewById(R.id.T);
        mFalseButton = (Button)findViewById(R.id.F);
        tv = (TextView)findViewById(R.id.qspace);
             
        nextButton = (Button)findViewById(R.id.next);
        prevButton = (Button)findViewById(R.id.prev);
        
        tv.setText(getQuestionString());  
        
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
		if(mQuestionBank[index].getAnswer() == ans)
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
    
    
}

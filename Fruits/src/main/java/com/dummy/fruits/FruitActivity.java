package com.dummy.fruits;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.Arrays;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;

import android.os.Trace;
import android.os.Debug;

//import com.dummy.fruits.ListListener;

public class FruitActivity extends Activity
{
	private ListView fruitlist;
	private ArrayAdapter<String> listAdapter;
	public ListListener listlisten;
	
	FruitFrag f1;
	FruitPic f2;
		
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("Venky", "In onCreate of FruitActivity");
        
        //This is how you create a simple ListView Activity
        /*String fruits[] = { "apple", "orange", "mango", "water melon"};
        listlisten = new ListListener(fruits);
        fruitlist = (ListView)findViewById(R.id.fruitlist);
        fruitlist.setOnItemClickListener(listlisten);
        
        
        ArrayList<String> fl = new ArrayList<String>();
        fl.addAll(Arrays.asList(fruits));
        
        listAdapter = new ArrayAdapter<String>(this,R.layout.simplerow, fl);
        fruitlist.setAdapter(listAdapter);*/
        
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        f1 = (FruitFrag)fm.findFragmentByTag("FruitFrag");
        if(f1 == null)
        {
          f1 = new FruitFrag();
        }
        Log.d("Venky", "Created new FruitFrag: " + f1.toString());
        ft.add(R.id.placeholder,f1,"FruitFag");
        ft.addToBackStack(null);
        ft.commit();
       
    }
    
    public void showFruit(String fruit)
    {
	  
	  Log.d("Venky", "Need to show image for " + fruit);	
	  FragmentManager fm = getFragmentManager();
      FragmentTransaction ft = fm.beginTransaction();
      f2 = (FruitPic)fm.findFragmentByTag("FruitPic");
      if(f2 == null)
      {
        f2 = new FruitPic();
      }
      f2.setFruit(fruit);
      ft.replace(R.id.placeholder,f2,"FruitPic");
      ft.addToBackStack(null);
      ft.commit();
     
	}
}

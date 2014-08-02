package com.dummy.fruits;

import android.app.Fragment;
import android.app.Activity;

import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;

import android.widget.ImageView;
import android.util.Log;

public class FruitPic extends Fragment
{
	String fruit;
	private ImageView imgView;
	
	public void setFruit(String _fruit)
	{
		fruit = _fruit;
	}
		
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // retain this fragment
        setRetainInstance(true);
    }	
		
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                            Bundle b)
	{
	  Log.d("Venky", "In onCreateView of FruitPic");
	  super.onCreateView(inflater, container, b);
	  View v = inflater.inflate(R.layout.fruitpic, container,false);
	  imgView = (ImageView) v.findViewById(R.id.imageView1);
      
      if(fruit.equals("mango"))
      {
		Log.d("Venky", "In mango pic viewer");  
	    imgView.setImageResource(R.drawable.mango);	  
	  }
	  else if(fruit.equals("orange"))
	  {
		imgView.setImageResource(R.drawable.orange);	  
	  }
	  else if(fruit.equals("water melon"))
      {
	    imgView.setImageResource(R.drawable.watermelon);
	  }
	  else if(fruit.equals("apple"))
	  {
		imgView.setImageResource(R.drawable.apple);	 
	  }
	  
	  Log.d("Venky", "Returning pic view");
	  return v;
	}
}

package com.dummy.fruits;

import android.app.Activity;
import android.widget.AdapterView;
import android.view.View;
import android.util.Log;

import com.dummy.fruits.FruitActivity;


public class ListListener implements android.widget.AdapterView.OnItemClickListener
{
	 private String listitems[];
	 private FruitActivity fruitActivity;
	 public ListListener(String fruits[], Activity mainact)
	 {
		 listitems = fruits;
		 fruitActivity = (FruitActivity)mainact;
	 }
	 
	 public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	 {
	    Log.d("Venky", "Position : " + listitems[position]);
	    fruitActivity.showFruit(listitems[position]);	 
	 }

}

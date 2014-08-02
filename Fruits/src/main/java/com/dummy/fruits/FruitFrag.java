package com.dummy.fruits;

import android.app.Fragment;
import android.app.Activity;

import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;

import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.Arrays;

import android.util.Log;

public class FruitFrag extends Fragment
{
	private View v;
	private ListView fruitlist;
	private ArrayAdapter<String> listAdapter;
	public ListListener listlisten;
	private Activity hostActivity;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // retain this fragment
        //setRetainInstance(true);
        //OR:
        //<!--android:configChanges="orientation|screenSize" --> 
    }

	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                            Bundle b)
	{
	  super.onCreateView(inflater, container, b);
	  v = inflater.inflate(R.layout.fruitfrag, container,false);
	  
	  String fruits[] = { "apple", "orange", "mango", "water melon"};
	  listlisten = new ListListener(fruits, hostActivity );
	  fruitlist = (ListView)v.findViewById(R.id.fruitlist);
	  fruitlist.setOnItemClickListener(listlisten);
      ArrayList<String> fl = new ArrayList<String>();
      fl.addAll(Arrays.asList(fruits)); 
      listAdapter = new ArrayAdapter<String>(hostActivity,R.layout.simplerow, fl);
      fruitlist.setAdapter(listAdapter);
	  Log.d("Venky", "In onCreateView");
	  return v;
    }
    
    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        hostActivity = activity;
        Log.d("Venky", "In onAttach");
    }
}

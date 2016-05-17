package com.dummy.criminalintent;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.os.Bundle;

public class CriminalIntent extends Activity
{
	
	private FragmentManager fragManager;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        fragManager = getFragmentManager();
        Fragment f = fragManager.findFragmentById(R.id.fragmentContainer);
        if(f == null)
        {
		  f = new CrimeFragment();
		  FragmentTransaction t = fragManager.beginTransaction();	
		  t = t.add(R.id.fragmentContainer, f);
		  t.commit();
		}
    }	
}

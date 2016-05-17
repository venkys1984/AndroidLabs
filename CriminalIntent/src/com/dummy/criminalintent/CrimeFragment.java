package com.dummy.criminalintent;

import android.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import android.text.TextWatcher;
import android.widget.EditText;
import android.text.Editable;

public class CrimeFragment extends Fragment
{
	private Crime mCrime;
	private EditText mTitleField;
	
	public void onCreate(Bundle savedInstance)
	{
	   super.onCreate(savedInstance);
	   mCrime = new Crime();	
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
	{
	  View v = inflater.inflate(R.layout.crime_fragment, container, false);
	  
	  mTitleField = (EditText)v.findViewById(R.id.crime_title);
	  mTitleField.addTextChangedListener(new TextWatcher(){
		  
		  public void beforeTextChanged(CharSequence s , int start, int count, int after)
		  {}
		  
		  public void onTextChanged(CharSequence s , int start, int before, int count)
		  {
		    mCrime.setTitle(s.toString());
		  }
		  
		  public void afterTextChanged(Editable s)
		  {}
		  
		  });

	  return v;	
	}
	
}

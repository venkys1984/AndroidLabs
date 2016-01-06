package com.dummy.geoquiz;

public class TrueFalse
{
  public int question;
  public boolean answer;
  
  public TrueFalse(int q, boolean a)
  {
	 question = q;
	 answer = a;  
  }
  
  public int getQuestion()
  {
	 return question;  
  }

  public boolean getAnswer()
  {
	 return answer;  
  }  
  
  public void setQuestion(int q, boolean a)
  {
	 question = q;
	 answer = a;    
  }
}

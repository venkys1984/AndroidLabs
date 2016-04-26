package com.dummy.musicplayer;

import android.app.Activity;
import android.os.Bundle;

import android.media.MediaExtractor;
import android.util.Log;
import java.lang.Exception;
import java.nio.ByteBuffer;

public class Play extends Activity
{
    private MediaExtractor extractor;
    
    /** Called when the activity is first created. */    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /** Path :  /storage/sdcard0/Download/song.mp3 */
    }
    @Override
    
    public void onResume() 
    {
	  try
	  {	
        super.onResume();  // Always call the superclass method first
        Log.d("play" , "Activity is up");
        extractor = new MediaExtractor();
        extractor.setDataSource("/storage/sdcard0/Download/song.mp3");
        int numTracks = extractor.getTrackCount();
        Log.d("play", "Tracks found: " + String.valueOf(numTracks)); 
        
        //important . just hard-coding to track 0 for now 
        extractor.selectTrack(0);

        ByteBuffer inputBuffer = ByteBuffer.allocate(5000);
        int sampleSize = 1;
        while (sampleSize >= 0) 
        {
		  sampleSize = extractor.readSampleData(inputBuffer, 0); 	
		  if(sampleSize <= 0)
		  {
			 Log.d("play", "Breaking out...");
			 break;  
		  }
		  Log.d("play", "Frame size: " + String.valueOf(sampleSize));
          int trackIndex = extractor.getSampleTrackIndex();
          long presentationTimeUs = extractor.getSampleTime();
   
          extractor.advance();
        }

        
      }
      catch(Exception exc)
      {
		  exc.printStackTrace();
	  }
      
    }

}

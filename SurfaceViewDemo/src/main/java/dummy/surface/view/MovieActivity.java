package dummy.surface.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.util.Log;
import android.media.MediaPlayer;
import java.io.IOException;


public class MovieActivity extends Activity implements SurfaceHolder.Callback
{
	MediaPlayer mp;
	SurfaceView mSurfaceView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mp = new MediaPlayer();
        mSurfaceView = (SurfaceView) findViewById(R.id.mysurface);
        mSurfaceView.getHolder().addCallback(this);
     }
    
    public void surfaceCreated(SurfaceHolder holder)
    {
	   	Log.d("Venky", "In surfaceCreated");
	   	try
	   	{
		  mp.setDisplay(mSurfaceView.getHolder());
	   	  mp.setDataSource("file:///sdcard/WhatsApp/Media/WhatsApp Video/VID-20140817-WA0006.mp4");
	   	  mp.prepare();
	   	  float videoWidth = mp.getVideoWidth();
          float videoHeight = mp.getVideoHeight();
          Log.d("Venky", "Res: " + Float.toString(videoWidth) + " x " + Float.toString(videoHeight));
          
	   	  mp.start();
	   	}
	   	catch(IOException io)
	   	{}
	   	
	}
	public void surfaceChanged (SurfaceHolder holder, int format, int width, int height)
	{
		
	}
	
	public void surfaceDestroyed (SurfaceHolder holder)
	{
      mp.stop();
	  mp.release();
	  mp = null;	
	}
	
	public void onDestroy()
	{
	 
	}
}

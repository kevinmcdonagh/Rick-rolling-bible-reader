package com.novoda;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewDemo extends Activity {
	private MediaController mc;
	private static final String OPEN_COUNT = "open_count";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
       int count = PreferenceManager.getDefaultSharedPreferences(this).getInt(OPEN_COUNT, 0);
       Log.i("JESUS", "open number = " + count);

       boolean isEven = (count % 3 == 0);
       
       if(isEven){
    	   ((View)findViewById(R.id.title1)).setVisibility(View.GONE);
    	   ((View)findViewById(R.id.para1)).setVisibility(View.GONE);
    	   VideoView vd = (VideoView) findViewById(R.id.surfaceview);
    	   Uri uri = Uri.parse("android.resource://"+getPackageName() + "/"+R.raw.rick);
    	   mc = new MediaController(this);
    	   vd.setMediaController(mc);
    	   vd.setVideoURI(uri);
    	   vd.start();
       }else{
    	   ((View)findViewById(R.id.surfaceview)).setVisibility(View.GONE);
       }
       
       count++;
       PreferenceManager.getDefaultSharedPreferences(this).edit().putInt(OPEN_COUNT, count).commit();

       
    }
}
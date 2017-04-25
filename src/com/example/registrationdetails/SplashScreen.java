package com.example.registrationdetails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends Activity {
	
	private boolean backbtnpressed;
	private static final int SPLASH_DURATION=3000;
	private Handler myhandler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		myhandler=new Handler();
		myhandler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				finish();
				if(!backbtnpressed){
					Intent in=new Intent(SplashScreen.this,PageOne.class);
					SplashScreen.this.startActivity(in);
				}
				
			}
		}, SPLASH_DURATION);
	}
public void OnBackPressed(){
	backbtnpressed=true;
	super.onBackPressed();
}
	
	
}

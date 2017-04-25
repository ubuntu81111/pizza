package com.example.registrationdetails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class PageOne extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page_one);
	}
	public void signup(View v){
		Intent in=new Intent(PageOne.this,MainActivity.class);
		finish();
		startActivity(in);
	}
	public void signin(View v){
		Intent in=new Intent(PageOne.this,SecndActivity.class);
		finish();
		startActivity(in);
	}
	public void exi(View v){
		finish();
	}

}

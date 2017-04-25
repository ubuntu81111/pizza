package com.example.registrationdetails;

import android.R.menu;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends Activity {
Button menubtn,offerbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
	menubtn=(Button) findViewById(R.id.menu);
	offerbtn=(Button) findViewById(R.id.everydayoffer);
	
	menubtn.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		Intent intent=new Intent(getApplicationContext(),menu.class);
		finish();
		startActivity(intent);
		
		}
	});

		
	}
	
}

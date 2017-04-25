package com.example.registrationdetails;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class SecndActivity extends Activity {
private SQLiteDatabase db;
EditText email,paswrd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_secnd);
		
		Bundle b=getIntent().getExtras();
		String msg=b.getString("send_data");
		Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
		email=(EditText) findViewById(R.id.Email_second);
		paswrd=(EditText) findViewById(R.id.Passwrd_second);
		db=openOrCreateDatabase("rex", Context.MODE_PRIVATE,null);
	}
	public void login(View v){
		String em=email.getText().toString();
		String pas=paswrd.getText().toString();
		Cursor res=db.rawQuery("select * from " + " reg where e_email='" + em
				+ "'and e_paswrd='" + pas + "'", null);
		
		
		if(res.moveToNext()){
			Toast.makeText(this, "Login success",Toast.LENGTH_SHORT).show();
			db.close();
			Intent in=new Intent(this,ThirdActivity.class);
			finish();
			startActivity(in);
		}else{
			Toast.makeText(this, "Login unsuccessful",Toast.LENGTH_LONG).show();
			db.close();
		}
		
	}
	
	public void forget(View v){
		Intent in=new Intent(SecndActivity.this,ForgetActivity.class);
		finish();
		startActivity(in);
	}

}

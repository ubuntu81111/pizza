package com.example.registrationdetails;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ForgetActivity extends Activity {
	EditText et1;
	Button b1;
	private SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forget);
		et1=(EditText) findViewById(R.id.Frgtemail);
		b1=(Button) findViewById(R.id.next);
		db=openOrCreateDatabase("rex", Context.MODE_PRIVATE,null);
		
	}
	public void next(View v){
		String cheml=et1.getText().toString();
		Cursor res=db.rawQuery("select e_email from " + " reg where e_email='" + cheml + "'",null);
		if(res.moveToNext()){
			Toast.makeText(getApplicationContext(), "Right email", Toast.LENGTH_SHORT).show();
			db.close();
			Intent in=new Intent(ForgetActivity.this,Forget1Activity.class);
			finish();
			startActivity(in);
			
		}else if(et1.getText().toString().trim().equals("")){
			et1.setError("Please enter yr email");
		}else{
		Intent in=new Intent(ForgetActivity.this,Forget1Activity.class);
		finish();
		startActivity(in);
		}
	}

	}

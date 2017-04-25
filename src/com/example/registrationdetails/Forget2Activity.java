package com.example.registrationdetails;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Forget2Activity extends Activity {
EditText e1;
private SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forget2);
		e1=(EditText) findViewById(R.id.newpasswrd);
		db=openOrCreateDatabase("rex", Context.MODE_PRIVATE, null);
	}
	public void sub(View v){
		String np=e1.getText().toString();
		String sql="UPDATE Reg SET e_paswrd='"+np+"'";
		db.execSQL(sql);
		Toast.makeText(getApplicationContext(), "Password succesfully change", Toast.LENGTH_LONG).show();
		Intent in=new Intent(Forget2Activity.this,SecndActivity.class);
		finish();
		startActivity(in);
	}

}

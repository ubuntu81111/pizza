package com.example.registrationdetails;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Forget1Activity extends Activity {
EditText et;
private SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forget1);
		et=(EditText) findViewById(R.id.AnsText1);
		
		db=openOrCreateDatabase("rex", Context.MODE_PRIVATE, null);
	}
public void next(View v){
	String seans=et.getText().toString();
	Cursor res=db.rawQuery("select e_sqans from " + " reg where e_sqans='" + seans + "'", null);
	if(res.moveToNext()){
		Toast.makeText(getApplicationContext(), "right ans", Toast.LENGTH_SHORT).show();
		Intent in=new Intent(Forget1Activity.this,Forget2Activity.class);
		finish();
		startActivity(in);
		db.close();
	}else{
		Toast.makeText(getApplicationContext(), "Wrong ans", Toast.LENGTH_SHORT).show();
		
	}
	
	
}

}

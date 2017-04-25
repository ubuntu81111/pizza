package com.example.registrationdetails;


import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	Spinner sp;
	ArrayAdapter<String>aa;
	String c1[];
EditText email,paswrd,sq,sqans;
private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=(Spinner) findViewById(R.id.Sq_first);
        c1=getResources().getStringArray(R.array.security_arrays);
        aa=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,c1);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);
        email=(EditText) findViewById(R.id.Email_First);
        paswrd=(EditText) findViewById(R.id.Password_first);
        sq=(EditText) findViewById(R.id.editText1);
        sq.setVisibility(View.INVISIBLE);
        sqans=(EditText) findViewById(R.id.Ans_first);
        
        sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				int ind=arg0.getSelectedItemPosition();
				if(c1[ind].equals("select question"))
				{
					sq.setText("");
				}else{
					sq.setText(c1[ind]+ "is selected");
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Please select a question",Toast.LENGTH_SHORT
						).show();
			}
		});
        
        db=openOrCreateDatabase("rex", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Reg(e_email text primary key,"
				+ "e_paswrd text, e_sq text,  e_sqans text);");
        
    }
    
    public void register(View v)
    {
    	ContentValues row=new ContentValues();
    	row.put("e_email", email.getText().toString());
    	row.put("e_paswrd", paswrd.getText().toString());
    	row.put("e_sq", sq.getText().toString());
    	row.put("e_sqans",sqans.getText().toString());
    	db.insert("reg", null, row);
    	
    	email.setText("");
    	paswrd.setText("");
    	sq.setText("");
    	sqans.setText("");
    	Toast.makeText(getBaseContext(), "registeration sucess",
				Toast.LENGTH_SHORT).show();

		db.close();
		String x=String.valueOf(sq);
		Intent in = new Intent(MainActivity.this,SecndActivity.class);
		Bundle b=new Bundle();
		b.putString("send_data",x);
		in.putExtras(b);
		finish();
		startActivity(in);
		
    }
    
    
}

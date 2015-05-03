package com.example.iqbal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Forgot_Password extends Activity {

	
	Button next;
	EditText edit;
	String email;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forgot__password);
		next = (Button) findViewById(R.id.button1);
		edit = (EditText) findViewById(R.id.editText1);
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				if(edit.getText().length() > 0)
				{
					email = edit.getText().toString();
					new mail().execute();
				}
			}
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_forgot__password, menu);
		return true;
	}
	
	public class mail extends AsyncTask<Void, Void, String>
	{

		@Override
		protected String doInBackground(Void... params) 
		{
			try
			{
				HttpClient client = new DefaultHttpClient();
				HttpGet request = new HttpGet();
				request.setURI(new URI(canstants.Server_Path + "forgot.php?email=" + email));
				HttpResponse response = client.execute(request);
				
				BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				String line = in.readLine();
				if(line.equals("1"))
					return "Mail Successfully Sent!";
				
				
			}catch(Exception ex) {   }
			return null;
		}

		@Override
		protected void onPostExecute(String result) 
		{
			Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
			
			super.onPostExecute(result);
		}
		
	}

}

package com.example.iqbal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Log_in extends Activity {

	
	
	EditText userName, Password;
	Button login;
	String success;
	TextView forgot;
	
	EditText user, first, lname, pass, cpass, email;
	String userN, firstName, lastName, passw, cpassw, mail;
	Button reset, signup;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		String msg = getIntent().getStringExtra("msg");
		
		if(msg.equalsIgnoreCase("login"))
		{
			setContentView(R.layout.activity_log_in);
			
			forgot = (TextView) findViewById(R.id.textView3);
			userName = (EditText) findViewById(R.id.editText1);
			Password = (EditText) findViewById(R.id.editText2);
			login = (Button) findViewById(R.id.button1);
			
			login.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) 
				{
					String user = userName.getText().toString();
					String password = Password.getText().toString();
					new login(user, password).execute();
				}
			});
			forgot.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) 
				{
					startActivity(new Intent(Log_in.this, Forgot_Password.class));
				}
			});
			
		}
		else if(msg.equalsIgnoreCase("signup"))
		{
			setContentView(R.layout.sign_up);
			
			user = (EditText) findViewById(R.id.userName);
			first = (EditText) findViewById(R.id.Fname);
			lname = (EditText) findViewById(R.id.Lname);
			pass = (EditText) findViewById(R.id.password);
			cpass = (EditText) findViewById(R.id.cPassword);
			email = (EditText) findViewById(R.id.email);
			reset = (Button) findViewById(R.id.reset);
			signup = (Button) findViewById(R.id.signup);
			
			reset.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) 
				{
					reset();
				}
			});
			signup.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) 
				{
					userN = user.getText().toString();
					firstName = first.getText().toString();
					lastName = first.getText().toString();
					passw = pass.getText().toString();
					cpassw = cpass.getText().toString();
					mail = email.getText().toString();
					
					new signUp().execute();
				}
			});
			
		}
	}
	
	public void reset()
	{
		user.setText(""); first.setText(""); lname.setText(""); pass.setText(""); cpass.setText("");
		email.setText("");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_log_in, menu);
		return true;
	}
	
	
	public class login extends AsyncTask<Void, Void, Void>
	{
		String u;
		String p;
		
		public login(String user, String pass)
		{
			this.u = user;
			this.p = pass;
		}

		@Override
		protected Void doInBackground(Void... params) 
		{
			
			try
			{
	            String link =  canstants.Server_Path + "logIn.php?username="
	            +u+"&password="+p;
	            HttpClient client = new DefaultHttpClient();
	            HttpGet request = new HttpGet();
	            request.setURI(new URI(link));
	            HttpResponse response = client.execute(request);
	            BufferedReader in = new BufferedReader
	           (new InputStreamReader(response.getEntity().getContent()));
	
	           StringBuffer sb = new StringBuffer("");
	           String line="";
	           while ((line = in.readLine()) != null) {
	              sb.append(line);
	              break;
	            }
	           
	            in.close();
	            canstants.User_Name = sb.toString();
	            
			}catch(Exception ex){}
			return null;
			
		}

		@Override
		protected void onPostExecute(Void result) 
		{
			super.onPostExecute(result);
			Toast.makeText(getApplicationContext(), canstants.User_Name, Toast.LENGTH_SHORT).show();
		}
		
	}
	
	public class signUp extends AsyncTask<Void, Void, String>
	{

		@Override
		protected String doInBackground(Void... params) 
		{
			try
			{
				String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(userN, "UTF-8");
					data += "&" + URLEncoder.encode("Fname", "UTF-8") + "=" + URLEncoder.encode(firstName, "UTF-8");
					data += "&"	+ URLEncoder.encode("Lname", "UTF-8") + "=" + URLEncoder.encode(lastName, "UTF-8");
					data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(passw, "UTF-8");
					data += "&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(mail, "UTF-8");
					
					URL url = new URL(canstants.Server_Path + "signup.php");
					URLConnection conn = url.openConnection();
					conn.setDoOutput(true);
					OutputStreamWriter ws = new OutputStreamWriter(conn.getOutputStream());
					ws.write(data);
					ws.flush();
					
					BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					StringBuilder sb = new StringBuilder();
					String line = null;
					
					while((line = reader.readLine()) != null)
		            {
		               sb.append(line);
		               break;
		            }
		            if(sb.length() == 0)
		            {
		            	success = "Login Not Successful";
		            	return null;
		            }
		            else
		            {
		            	success = "Login Successful";
		            	return sb.toString();
		            }
					
					
					
			}catch(Exception ex){}
			
			return null;
		}

		@Override
		protected void onPostExecute(String result) 
		{
			Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
			reset();
			super.onPostExecute(result);
		}
		
	}
	
	
	

}

package com.example.iqbal;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	ImageView[] imgs;
	OnClickListener l;
	Intent i;
	String server, name;
	ArrayList<String> list;
	LinearLayout outerLayout;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        
        imgs = new ImageView[]{
        (ImageView) findViewById(R.id.main),
        (ImageView) findViewById(R.id.side1),
        (ImageView) findViewById(R.id.side2)
        };
        
        outerLayout = (LinearLayout) findViewById(R.id.Outerlayout);
        new fetch(imgs, this, outerLayout).execute();
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
    
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) 
    {
    	switch (item.getItemId()) 
    	{
			case R.id.logIn:
				Intent in = new Intent(this, Log_in.class);
				in.putExtra("msg", "login");
				startActivity(in);
				break;
			case R.id.signUp:
				Intent inn = new Intent(this, Log_in.class);
				inn.putExtra("msg", "signup");
				startActivity(inn);
				break;
				
			case R.id.check:
				Toast.makeText(this, canstants.User_Name, Toast.LENGTH_SHORT).show();
				break;
				
			case R.id.logout:
				canstants.User_Name = "Not Signed In";
				Toast.makeText(this, "Successfully Logged Out!", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
		}
    	
		return super.onOptionsItemSelected(item);
	}




	
}

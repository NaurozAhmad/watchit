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
import android.widget.Toast;

public class MainActivity extends Activity {

	
	ImageView[] imgs;
	OnClickListener l;
	Intent i;
	String server, name;
	ArrayList<String> list;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        
        imgs = new ImageView[]
        		{
        		(ImageView) findViewById(R.id.imageView1),
        		(ImageView) findViewById(R.id.imageView2),
        		(ImageView) findViewById(R.id.imageView3),
        		(ImageView) findViewById(R.id.imageView4),
        		(ImageView) findViewById(R.id.imageView5),
        		(ImageView) findViewById(R.id.imageView6),
        		(ImageView) findViewById(R.id.imageView7),
        		(ImageView) findViewById(R.id.ImageView01),
        		(ImageView) findViewById(R.id.ImageView02),
        		(ImageView) findViewById(R.id.ImageView03),
//        		(ImageView) findViewById(R.id.ImageView04),
//        		(ImageView) findViewById(R.id.ImageView05),
//        		(ImageView) findViewById(R.id.ImageView06),
//        		(ImageView) findViewById(R.id.ImageView07),
//        		(ImageView) findViewById(R.id.ImageView08),
//        		(ImageView) findViewById(R.id.ImageView09),
//        		(ImageView) findViewById(R.id.ImageView10),
        		
        };
        
        //new loadingImage((ImageView) findViewById(R.id.imageView1), this).execute("http://10.0.2.2/iqbal/Images/main.jpg");
        list = new ArrayList<String>();
        new fetch(imgs, this).execute();
        
        l = new listener();
        server = canstants.Server_Path;
        
        //Image views references and setting tags
//        main = (ImageView) findViewById(R.id.imageView1);
//        one = (ImageView) findViewById(R.id.imageView2);
//        two = (ImageView) findViewById(R.id.imageView3);
        
        
        
        
        i = new Intent(MainActivity.this, Contentview.class);
        
        //img views listener
//        main.setOnClickListener(l);
//        one.setOnClickListener(l);
//        two.setOnClickListener(l);
        
        
//        Toast.makeText(this, list.toArray().length, Toast.LENGTH_SHORT).show();
        
        
        
        for(int ii=0; ii<imgs.length; ii++)
        {
        	imgs[ii].setOnClickListener(l);
        }
        
        
//        new background(main, this).execute(server + "main.jpg");
//        new background(one, this).execute(server + "one.jpg");
//        new background(two, this).execute(server + "two.jpg");
        
        
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




	public class listener implements View.OnClickListener
    {

		@Override
		public void onClick(View v) 
		{
			String tag = v.getTag().toString();
			i.putExtra("tag", tag);
			startActivity(i);
		}
    	
    }
}

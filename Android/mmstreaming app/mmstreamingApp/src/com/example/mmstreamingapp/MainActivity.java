package com.example.mmstreamingapp;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AbstractNavDrawerActivity {

	
	ImageView[] imgs;
	OnClickListener l;
	Intent i;
	String server, name;
	ArrayList<String> list;
	LinearLayout outerLayout;
	Bundle b;
//	NavDrawerItem[] menu;
	ArrayList<NavDrawerItem> menu;
	
	
	
	
	
	
	@Override
	protected NavDrawerActivityConfiguration getNavDrawerConfiguration() 
	{
		
			menu = new ArrayList<NavDrawerItem>();
		
					menu.add(NavProfile.create(100, canstants.User_Name ,"@drawable/signin",true,this));
					menu.add(NavMenuItem.create(200,"MostRated","@drawable/ic_launcher",true,this));
					menu.add(NavMenuSection.create( 300, "Categories"));
					menu.add(NavMenuItem.create(301, "Entertainment", "@drawable/entertainment", true, this));
					menu.add(NavMenuItem.create(302, "Sports", "@drawable/sports", true, this));
					menu.add(NavMenuItem.create(303, "Horror", "@drawable/ic_launcher", true, this));
					menu.add(NavMenuItem.create(304, "Islamic", "@drawable/islamic", true, this));
					menu.add(NavMenuItem.create(305, "Dramas", "@drawable/dramas", true, this));
					menu.add(NavMenuItem.create(306, "Animated", "@drawable/animated", true, this));
					
                    
		if(!canstants.User_Name.equalsIgnoreCase("Sign in"))
		{
			menu.add(NavMenuSection.create(400, "Others"));
			menu.add(NavMenuItem.create(401, "Sign Out", "@drawable/ic_launcher", true, this));
		}

		
			NavDrawerAdapter adapter =  new NavDrawerAdapter(this, R.layout.navdraweritem, menu );


            NavDrawerActivityConfiguration navDrawerActivityConfiguration = new NavDrawerActivityConfiguration();
            navDrawerActivityConfiguration.setMainLayout(R.layout.activity_main);
            navDrawerActivityConfiguration.setDrawerLayoutId(R.id.drawer_layout);
            navDrawerActivityConfiguration.setLeftDrawerId(R.id.left_drawer);
            navDrawerActivityConfiguration.setNavItems(menu);
            navDrawerActivityConfiguration.setDrawerShadow(R.drawable.drawer_shadow);
            navDrawerActivityConfiguration.setDrawerOpenDesc(R.string.drawer_open);
            navDrawerActivityConfiguration.setDrawerCloseDesc(R.string.drawer_close);
            navDrawerActivityConfiguration.setBaseAdapter(adapter);
            return navDrawerActivityConfiguration;
	}
	
	

	@Override
	protected void onNavItemSelected(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        
//        
//        this.b = savedInstanceState;
//        
//        if(isOnline())
//        {
//        	setContentView(R.layout.lay);
//            
//            imgs = new ImageView[]{
//            (ImageView) findViewById(R.id.main),
//            (ImageView) findViewById(R.id.side1),
//            (ImageView) findViewById(R.id.side2)
//            };
//            
//            outerLayout = (LinearLayout) findViewById(R.id.Outerlayout);
//            new fetch(imgs, this, outerLayout).execute();
//        }
//        else
//        {
//        	setContentView(R.layout.activity_home_screen);
//        	((Button) findViewById(R.id.button1)).setOnClickListener(new OnClickListener() {
//				
//				@Override
//				public void onClick(View v) 
//				{
//					onCreate(b);
//				}
//			});
//        	Toast.makeText(getApplicationContext(), "Please Make sure Availablitiy of the Network", Toast.LENGTH_LONG).show();
//        }
//        
//        
//    }
    
    public boolean isOnline()
    {
    	ConnectivityManager manager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
    	NetworkInfo info = manager.getActiveNetworkInfo();
    	boolean connected = info != null && info.isAvailable() && info.isConnected();
    	return connected;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        getMenuInflater().inflate(R.menu.main, menu);
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
				canstants.User_Name = "Sign In";
				Toast.makeText(this, "Successfully Logged Out!", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
		}
    	
		return super.onOptionsItemSelected(item);
	}




	
}

package com.example.iqbal;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class Contentview extends Activity {

	
	VideoView videoPlayer, v;
	MediaController controller;
	ProgressDialog pd;
	String tag, Stitle, Sdesc;
	Uri uri;
	TextView title, desc, comment;
	Button download;
	LinearLayout ll;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content_view);
		
		download = (Button) findViewById(R.id.button1);
		title = (TextView) findViewById(R.id.textView1);
		desc = (TextView) findViewById(R.id.textView2);
		ll = (LinearLayout) findViewById(R.id.commentsLayout);
		
		tag = getIntent().getStringExtra("tag");
		String[] str = tag.split(":");
		Stitle = str[2];
		Sdesc = str[3];
		
		comments(str[0]);
		
		uri = Uri.parse( canstants.Server_Path + "videos/" + str[1] + ".mp4");
		
		pd = new ProgressDialog(this);
		pd.setMessage("Loading..........!");
		pd.setTitle("Please Show patience");
		pd.setCancelable(false);
		pd.setIndeterminate(false);
		pd.show();
		videoPlayer = (VideoView) findViewById(R.id.videoView1);
		videoPlayer.setVideoURI(uri);
		videoPlayer.requestFocus();
		
		
		title.setText(Stitle);
		desc.setText(Sdesc);
		
		
		controller = new MediaController(this);
		controller.setAnchorView(videoPlayer);
		videoPlayer.setMediaController(controller);

		
		
		
		videoPlayer.setOnPreparedListener(new OnPreparedListener() {
			
			@Override
			public void onPrepared(MediaPlayer mp) 
			{
				pd.dismiss();
				mp.start();
			}
		});
		
		download.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).mkdir();
				DownloadManager mgr = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
				mgr.enqueue(new DownloadManager.Request(uri)
							.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI |
													DownloadManager.Request.NETWORK_MOBILE)
							.setAllowedOverRoaming(true)
							.setAllowedOverMetered(true)
							.setTitle(Stitle)
							.setDescription(Sdesc)
							.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "test.mp4"));
			}
		});
		
	}
	
	public void comments(String id)
	{
		new fetchComments(id, ll).execute();
	}
	
	



	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		desc.setText("ahfkdsklfjksdfkl");
	}







	@Override
	protected void onSaveInstanceState(Bundle outState) 
	{
		super.onSaveInstanceState(outState);    
	}

	@Override
	protected void onRestoreInstanceState(Bundle state) 
	{
		super.onRestoreInstanceState(state);    
	}
	
	
	
	

	@Override
	public void onConfigurationChanged(Configuration newConfig) 
	{
		if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
		{
			ActionBar b = getActionBar();
			b.show();
			Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
		}
		else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
		{
			ActionBar bar = getActionBar();
			bar.hide();
			Toast.makeText(this, "Portarait", Toast.LENGTH_SHORT).show();
		}
		super.onConfigurationChanged(newConfig);
	}





	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_content_view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		
		switch (item.getItemId()) {
		case R.id.full_screen:			
			if(videoPlayer.isPlaying())
			{
				int seek = videoPlayer.getCurrentPosition();
				this.setContentView(R.layout.full_screen);
				v = (VideoView) findViewById(R.id.video);
				v.setMediaController(controller);
				v.setVideoURI(uri);
				v.seekTo(seek);
				v.start();
			}
			else if(v.isPlaying())
			{
				int value = v.getCurrentPosition();
				this.setContentView(R.layout.activity_content_view);
				videoPlayer = (VideoView) findViewById(R.id.videoView1);
				videoPlayer.setVideoURI(uri);
				videoPlayer.seekTo(value);
				videoPlayer.start();
			}
			break;

		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	public class fetchComments extends AsyncTask<Void, Void, Void>
	{
		LinearLayout layout;
		String contentID;
		JSONObject obj;
		JSONArray data;
		String[][] comments;
		
		public fetchComments(String id, LinearLayout ll)
		{
			this.layout = ll;
			this.contentID = id;
		}
		

		@Override
		protected Void doInBackground(Void... params) 
		{
			try
	         {
	            String link = canstants.Server_Path + "comments.php?content_id=" + contentID;
	            HttpClient client = new DefaultHttpClient();
	            HttpGet request = new HttpGet();
	            request.setURI(new URI(link));
	            HttpResponse response = client.execute(request);
	            HttpEntity entity = response.getEntity();
	            String json = EntityUtils.toString(entity);
	            
	            obj = new JSONObject(json);
	            data = obj.getJSONArray("data");
	            comments = new String[data.length()][2];
	            for(int i=0; i<data.length(); i++)
	            {
	            	JSONObject O = data.getJSONObject(i);
	            	String comment = O.getString("comment");
	            	String Uname = O.getString("Uname");
	            	comments[i][0] = comment;
	            	comments[i][1] = Uname;
	            }
	            
	            
	      }catch(Exception e){
	         Log.d("exception in fetch", e.getMessage());
	      }
			return null;
		}


		@Override
		protected void onPostExecute(Void result) 
		{
			for(int i=0; i<comments.length; i++)
			{
				TextView Tuser = new TextView(getApplicationContext());
				TextView Tcomm = new TextView(getApplicationContext());
				String user = comments[i][1]  + ":";
				String com = comments[i][0];
				Tuser.setText(user);
				Tuser.setTextColor(Color.BLUE);
				Tuser.setTextSize(18);
				Tcomm.setText("\t\t" + com + "\n");
				Tcomm.setTextColor(Color.BLACK);
				Tcomm.setTextSize(12);
				layout.addView(Tuser);
				layout.addView(Tcomm);
			}
			
			
			super.onPostExecute(result);
		}
		
	}
	
	
}

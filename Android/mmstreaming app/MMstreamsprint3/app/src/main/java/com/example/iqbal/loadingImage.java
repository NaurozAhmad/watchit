package com.example.iqbal;

import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class loadingImage extends AsyncTask<String, Bitmap, Bitmap>
{
	ImageView img;
	Bitmap bm;
	Activity parent;
	String msg;
	
	
	public loadingImage(ImageView view, Activity p)
	{
		img = view;
		parent = p;
	}

	@Override
	protected Bitmap doInBackground(String... urls) 
	{
		try
        {
			String url = urls[0];
			url.replaceAll(" ", "+");
	        InputStream in = new java.net.URL(url).openStream();
	        bm = BitmapFactory.decodeStream(in);
        }catch(Exception e){ msg = e.getClass().toString();}
		
		return bm;
	}

	@Override
	protected void onPostExecute(Bitmap result) 
	{
		
		img.setImageBitmap(result);
	}
	
}

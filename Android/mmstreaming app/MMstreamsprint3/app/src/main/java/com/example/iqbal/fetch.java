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

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

public class fetch  extends AsyncTask<String, String, Void>
{
   public Activity activity;
   public ImageView[] BasicViews;
   String[][] ids;
   JSONObject obj;
   JSONArray data;
   Intent intent;
   
   LinearLayout outer, inner;
   listener l;
   
   
   
   public fetch(ImageView[] views, Activity a, LinearLayout outer) 
   {
      this.BasicViews = views;
      activity = a;
      ids = null;
      this.outer = outer;
      intent = new Intent(activity, Contentview.class);
      l = new listener(intent, a);
      
   }

   protected void onPreExecute()
   {
	   
   }
   
   @Override
   protected Void doInBackground(String... str) 
   {
         try
         {
            String link = canstants.Server_Path + "images.php";
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(link));
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            String json = EntityUtils.toString(entity);
            
//            BufferedReader in = new BufferedReader
//            (new InputStreamReader(response.getEntity().getContent()));

//            String line="";
//            while ((line = in.readLine()) != null) 
//            {
//            	items = line.split(",");
//            }
//            in.close();
            
            obj = new JSONObject(json);
            data = obj.getJSONArray("data");
            ids = new String[data.length()][4];
            for(int i=0; i<data.length(); i++)
            {
            	JSONObject O = data.getJSONObject(i);
            	String id = O.getString("id");
            	String path = O.getString("path");
            	String title = O.getString("title");
            	String desc = O.getString("desc");
            	ids[i][0] = id;
            	ids[i][1] = path;
            	ids[i][2] = title;
            	ids[i][3] = desc;
            }
            
            
      }catch(Exception e){
         Log.d("exception in fetch", e.getMessage());
      }
		return null;
   }
   
   @Override
   protected void onPostExecute(Void v)
   {
	   
	   new loadingImage(BasicViews[0], activity).execute(canstants.Server_Path + "Images/" + ids[0][1] + ".jpg");
	   BasicViews[0].setTag(ids[0][0] + ":" + ids[0][1] + ":" + ids[0][2] + ":" + ids[0][3]);
	   BasicViews[0].setOnClickListener(l);
	   
	   new loadingImage(BasicViews[1], activity).execute(canstants.Server_Path + "Images/" + ids[1][1] + ".jpg");
	   BasicViews[1].setTag(ids[1][0] + ":" + ids[1][1] + ":" + ids[1][2] + ":" + ids[1][3]);
	   BasicViews[1].setOnClickListener(l);
	   
	   new loadingImage(BasicViews[2], activity).execute(canstants.Server_Path + "Images/" + ids[2][1] + ".jpg");
	   BasicViews[2].setTag(ids[2][0] + ":" + ids[2][1] + ":" + ids[2][2] + ":" + ids[2][3]);
	   BasicViews[2].setOnClickListener(l);
	   
	   
	   int i=3;
	   while(i <= ids.length-3)
	   {
		   int width = BasicViews[1].getLayoutParams().width;
		   int height = BasicViews[1].getLayoutParams().height;
		   
		   inner = new LinearLayout(activity);
		   inner.setOrientation(LinearLayout.HORIZONTAL);
		   LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, height);
		   params.setMargins(0, 5, 0, 0);
		   inner.setLayoutParams(params);
		   
		   LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(width , height);
		   LinearLayout.LayoutParams p2 = new LinearLayout.LayoutParams(width, height);
		   LinearLayout.LayoutParams p3 = new LinearLayout.LayoutParams(width, height);
		   
		   ImageView view = new ImageView(activity); view.setLayoutParams(p1); view.setBackgroundColor(Color.BLACK);
		   new loadingImage(view, activity).execute(canstants.Server_Path + "Images/" + ids[i][1] + ".jpg");
		   view.setTag(ids[i][0] + ":" + ids[i][1] + ":" + ids[i][2] + ":" + ids[i][3]);
		   view.setOnClickListener(l);
		   inner.addView(view); i++;
		   
		   p2.setMargins(5, 0, 0, 0);
		   p3.setMargins(5, 0, 0, 0);
		   
		   ImageView view2 = new ImageView(activity); view2.setLayoutParams(p2); view2.setBackgroundColor(Color.BLACK);
		   new loadingImage(view2, activity).execute(canstants.Server_Path + "Images/" + ids[i][1] + ".jpg");
		   view2.setTag(ids[i][0] + ":" + ids[i][1] + ":" + ids[i][2] + ":" + ids[i][3]);
		   view2.setOnClickListener(l);
		   inner.addView(view2); i++;
		   
		   ImageView view3 = new ImageView(activity); view3.setLayoutParams(p3); view3.setBackgroundColor(Color.BLACK);
		   new loadingImage(view3, activity).execute(canstants.Server_Path + "Images/" + ids[i][1] + ".jpg");
		   view3.setTag(ids[i][0] + ":" + ids[i][1] + ":" + ids[i][2] + ":" + ids[i][3]);
		   view3.setOnClickListener(l);
		   inner.addView(view3); i++;
		   
		   
		   outer.addView(inner);
	   }
   }
   
   
   
}
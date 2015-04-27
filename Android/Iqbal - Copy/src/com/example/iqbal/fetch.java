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
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

public class fetch  extends AsyncTask<String, String, Void>
{
   public Activity activity;
   public ImageView[] views;
   String[][] ids;
   JSONObject obj;
   JSONArray data;
   
   
   
   public fetch(ImageView[] views, Activity a) 
   {
      this.views = views;
      activity = a;
      ids = null;
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
	   for(int i=0; i<views.length; i++)
	   {
		   views[i].setTag(ids[i][0] + ":" + ids[i][1] + ":" + ids[i][2] + ":" + ids[i][3]);
		   new loadingImage(views[i], activity).execute(canstants.Server_Path + "Images/" + ids[i][1] + ".jpg");
	   }
   }
}
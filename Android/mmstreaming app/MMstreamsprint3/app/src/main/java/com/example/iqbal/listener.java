package com.example.iqbal;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class listener implements View.OnClickListener
{
	Intent intent;
	Context c;
		public listener(Intent intent, Context c)
		{
			this.intent = intent;
			this.c = c;
		}

		@Override
		public void onClick(View v) 
		{
			String tag = v.getTag().toString();
			intent.putExtra("tag", tag);
			c.startActivity(intent);
		}
	
}
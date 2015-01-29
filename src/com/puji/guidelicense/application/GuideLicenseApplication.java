package com.puji.guidelicense.application;

import android.app.Application;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class GuideLicenseApplication extends Application {

	private RequestQueue mRequestQueue;

	@Override
	public void onCreate() {
		super.onCreate();
	}

	public synchronized RequestQueue getRequestQueue() {
		if (mRequestQueue == null) {
			mRequestQueue = Volley.newRequestQueue(getApplicationContext());
		}
		return mRequestQueue;
	}
}

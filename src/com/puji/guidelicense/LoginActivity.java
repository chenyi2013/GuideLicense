package com.puji.guidelicense;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.puji.guidelicense.application.GuideLicenseApplication;
import com.puji.guidelicense.bean.FloorData;
import com.puji.guidelicense.config.Urls;
import com.puji.guidelicense.util.JsonParser;
import com.puji.guidelicense.util.ProgressGenerator;
import com.puji.guidelicense.view.ActionProcessButton;

public class LoginActivity extends Activity implements
		ProgressGenerator.OnCompleteListener {

	public static final String FLOOR_INFO = "floor_info";

	private ActionProcessButton mLoginButton;
	private GuideLicenseApplication mApplication;
	private RequestQueue mRequestQueue;
	private FloorData mData;
	private EditText mUserName;
	private EditText mPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		mApplication = (GuideLicenseApplication) getApplication();
		mRequestQueue = mApplication.getRequestQueue();

		mLoginButton = (ActionProcessButton) findViewById(R.id.login_button);
		mLoginButton.setMode(ActionProcessButton.Mode.ENDLESS);
		mUserName = (EditText) findViewById(R.id.user_name);
		mPassword = (EditText) findViewById(R.id.password);

		final ProgressGenerator progressGenerator = new ProgressGenerator(this);
		mLoginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				progressGenerator.start(mLoginButton);
				loadData();
			}
		});

	}

	private void loadData() {

		JSONObject object = new JSONObject();
		try {
			object.put("Method", "devicelogin.login");
//			 object.put("UserName", "fuli14");
//			 object.put("Password", "123456");

			object.put("UserName", mUserName.getText().toString().trim());
			object.put("Password", mPassword.getText().toString().trim());
		} catch (JSONException e) {
			e.printStackTrace();
		}

		JsonObjectRequest request = new JsonObjectRequest(Method.POST,
				Urls.URL, object, new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {

						if (response != null && !response.toString().isEmpty()) {
							mData = JsonParser.getParsedData(
									response.toString(), FloorData.class);

							if (mData != null && mData.getData() != null
									&& mData.getData().getList() != null) {
								Intent intent = new Intent(LoginActivity.this,
										MainActivity.class);
								intent.putExtra(FLOOR_INFO, mData);
								startActivity(intent);
								finish();
							}
						}

					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

					}
				});

		request.setShouldCache(false);
		mRequestQueue.add(request);

	}

	@Override
	public void onComplete() {

	}
}

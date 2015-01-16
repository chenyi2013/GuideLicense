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
import com.puji.guidelicense.db.DatabaseDao;
import com.puji.guidelicense.util.JsonParser;
import com.puji.guidelicense.util.NetworkUtil;
import com.puji.guidelicense.util.ProgressGenerator;
import com.puji.guidelicense.util.SharePreferenceHelper;
import com.puji.guidelicense.view.ActionProcessButton;

/**
 * 用户登录界面
 * 
 * @author Kevin
 * 
 */
public class LoginActivity extends Activity implements
		ProgressGenerator.OnCompleteListener {

	public static final String FLOOR_INFO = "floor_info";

	private SharePreferenceHelper mHelper;

	private ActionProcessButton mLoginButton;
	private GuideLicenseApplication mApplication;
	private RequestQueue mRequestQueue;
	private FloorData mData;

	private EditText mUserNameEditText;
	private EditText mPasswordEditText;

	private String mUserName;
	private String mPassword;

	private DatabaseDao mDao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		mApplication = (GuideLicenseApplication) getApplication();
		mRequestQueue = mApplication.getRequestQueue();
		mHelper = new SharePreferenceHelper(this);
		mDao = new DatabaseDao(this);

		mLoginButton = (ActionProcessButton) findViewById(R.id.login_button);
		mLoginButton.setMode(ActionProcessButton.Mode.ENDLESS);

		mUserNameEditText = (EditText) findViewById(R.id.user_name);
		mPasswordEditText = (EditText) findViewById(R.id.password);

		final ProgressGenerator progressGenerator = new ProgressGenerator(this);

		// 如果以前登录过，尝试自动登录
		if (mHelper.isExistAccount() && mHelper.isExistPassword()) {
			mUserName = mHelper.getAccount();
			mPassword = mHelper.getPassword();

			if (mUserName != null && mPassword != null && !mUserName.isEmpty()
					&& !mPassword.isEmpty()) {
				mUserNameEditText.setText(mUserName);
				mPasswordEditText.setText(mPassword);
				progressGenerator.start(mLoginButton);
				login();
			}
		}

		mLoginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				mUserName = mUserNameEditText.getText().toString().trim();
				mPassword = mPasswordEditText.getText().toString().trim();

				if (mUserName == null || mUserName.isEmpty()) {

					mUserNameEditText.setError("用户名不能为空，请重新输入！");
					mUserNameEditText.requestFocus();
					return;

				}

				if (mPassword == null || mPassword.isEmpty()) {
					mPasswordEditText.setError("密码不能为空，请重新输入！");
					mPasswordEditText.requestFocus();
					return;
				}

				progressGenerator.start(mLoginButton);
				login();
			}
		});

	}

	// 登录
	private void login() {
		if (NetworkUtil.isNetworkConnected(LoginActivity.this)) {
			loadNetworkData();
		} else {
			loadLocalData(mUserName);
		}
	}

	private void switchNextAct() {

		Intent intent = null;
		if (mHelper.getCurrentFloor(mUserName) != null
				&& !mHelper.getCurrentFloor(mUserName).isEmpty()) {
			intent = new Intent(LoginActivity.this, MainActivity.class);

		} else {
			intent = new Intent(LoginActivity.this, PickerFloorActivity.class);
		}

		intent.putExtra(FLOOR_INFO, mData);
		startActivity(intent);
		finish();
	}

	// 加载本地数据
	private void loadLocalData(String userName) {
		String json = mDao.queryData(userName);
		if (json != null) {

			mData = JsonParser.getParsedData(json, FloorData.class);

			if (mData != null && mData.getData() != null
					&& mData.getData().getList() != null) {
				switchNextAct();
			}

		}

	}

	// 加载网络数据
	private void loadNetworkData() {

		JSONObject object = new JSONObject();
		try {
			object.put("Method", "devicelogin.login");
			// object.put("UserName", "fuli14");
			// object.put("Password", "123456");

			object.put("UserName", mUserName);
			object.put("Password", mPassword);
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
								// 存储用户名到共享参数中
								mHelper.saveAccount(mUserName);
								// 存储用户密码到共享参数中
								mHelper.savePassword(mPassword);
								// 将加载的网络数据保存到本地数据库中
								mDao.insertData(mUserName, response.toString());
								switchNextAct();

							}
						}

					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						loadLocalData(mUserName);
					}
				});

		request.setShouldCache(false);
		mRequestQueue.add(request);
	}

	@Override
	public void onComplete() {

	}
}

package com.puji.guidelicense.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceHelper {

	private static final String FILE_NAME = "guide_license";
	private static final String ACCOUNT = "account";
	private static final String PASSWORD = "password";

	private SharedPreferences mPreferences;

	public SharePreferenceHelper(Context context) {

		mPreferences = context.getSharedPreferences(FILE_NAME,
				Context.MODE_PRIVATE);
	}

	public boolean isExistPassword() {
		return mPreferences.contains(PASSWORD);
	}

	public boolean isExistAccount() {
		return mPreferences.contains(ACCOUNT);
	}

	public String getPassword() {
		return mPreferences.getString(PASSWORD, null);
	}

	public void savePassword(String mPassword) {
		mPreferences.edit().putString(PASSWORD, mPassword).commit();
	}

	public String getCurrentFloor(String account) {
		return mPreferences.getString(account, null);
	}

	public void saveCurrentFloor(String account, String mCurrentFloor) {
		mPreferences.edit().putString(account, mCurrentFloor).commit();
	}

	public String getAccount() {
		return mPreferences.getString(ACCOUNT, null);
	}

	public void saveAccount(String mAccount) {
		mPreferences.edit().putString(ACCOUNT, mAccount).commit();
	}

}

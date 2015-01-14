package com.puji.guidelicense.db;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 封装数据库增、删、查操作的业务类
 * 
 * @author Kevin Chen
 * 
 */
public class DatabaseDao {

	private final Activity activity;
	private static final String[] ID_TEXT_COL_PROJECTION = { DBHelper.ID_COL,
			DBHelper.TEXT_COL };

	public DatabaseDao(Activity activity) {

		this.activity = activity;

	}

	/**
	 * 插入一条数据记录
	 * 
	 * @param userName
	 * @param content
	 */
	public void insertData(String userName, String content) {

		SQLiteOpenHelper helper = new DBHelper(activity);
		SQLiteDatabase db = null;
		Cursor cursor = null;

		try {
			db = helper.getWritableDatabase();
			cursor = db.query(DBHelper.TABLE_NAME, ID_TEXT_COL_PROJECTION,
					DBHelper.ID_COL + "=?", new String[] { userName }, null,
					null, null);

			ContentValues contentValues = new ContentValues();
			contentValues.put(DBHelper.TEXT_COL, content);

			if (cursor.moveToNext()) {

				db.update(DBHelper.TABLE_NAME, contentValues, DBHelper.ID_COL
						+ "=?", new String[] { userName });
			} else {
				contentValues.put(DBHelper.ID_COL, userName);
				db.insert(DBHelper.TABLE_NAME, null, contentValues);
			}

		} finally {

			close(db, cursor);
		}

	}

	/**
	 * 查询数据记录
	 * 
	 * @param userName
	 * @return
	 */
	public String queryData(String userName) {
		SQLiteOpenHelper helper = new DBHelper(activity);
		SQLiteDatabase db = null;
		Cursor cursor = null;
		String str = null;
		try {
			db = helper.getReadableDatabase();
			cursor = db.query(DBHelper.TABLE_NAME, ID_TEXT_COL_PROJECTION,
					DBHelper.ID_COL + "=?", new String[] { userName }, null,
					null, null);
			if (cursor.moveToNext()) {
				str = cursor.getString(1);
			}
		} finally {
			close(db, cursor);
		}
		return str;

	}

	/**
	 * 删除数据
	 * 
	 * @param userName
	 */
	public void deleteData(String userName) {

		SQLiteOpenHelper helper = new DBHelper(activity);
		SQLiteDatabase db = null;
		Cursor cursor = null;
		try {

			db = helper.getReadableDatabase();
			cursor = db.query(DBHelper.TABLE_NAME, ID_TEXT_COL_PROJECTION,
					DBHelper.ID_COL + "=?", new String[] { userName }, null,
					null, null);
			if (cursor.moveToNext()) {
				db.delete(DBHelper.TABLE_NAME, DBHelper.ID_COL + "=?",
						new String[] { userName });
			}

		} finally {
			close(db, cursor);
		}

	}

	/**
	 * 关闭数据库和游标
	 * 
	 * @param db
	 * @param cursor
	 */
	private void close(SQLiteDatabase db, Cursor cursor) {

		if (db != null) {
			db.close();
		}

		if (cursor != null) {
			cursor.close();
		}

	}
}

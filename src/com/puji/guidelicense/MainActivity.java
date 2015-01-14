package com.puji.guidelicense;

import java.util.ArrayList;

import com.puji.guidelicense.bean.FloorData;
import com.puji.guidelicense.bean.FloorInfo;
import com.puji.guidelicense.view.FoolView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView mListView;
	private TextView mTitleTv;
	private GuideAdapter mAdapter;
	private ArrayList<FloorInfo> mFloors;

	private int itemLayout;
	private int headerLayout;

	private final int maxFontSize = 26;
	private final int minFontSize = 12;
	private String currentFloorId;

	private float tagSize = 12;
	private float shopsSize = 12;
	private float letterSize = 12;
	private float numberSize = 12;
	private float textFactor = 1;

	private boolean isA = false;
	private boolean isB = false;

	@SuppressLint("HandlerLeak")
	Handler mHandler = new Handler() {

		public void handleMessage(Message msg) {

			System.out.println(mListView.getLastVisiblePosition());

			if (mListView.getLastVisiblePosition() < mFloors.size() + 1) {
				isA = true;
				if (isB) {
					return;
				}

				if (tagSize > minFontSize) {
					tagSize = tagSize - 1;
					shopsSize = shopsSize - 1;
					mListView.setAdapter(mAdapter);
					mHandler.sendEmptyMessage(1);
				} else {
					textFactor = textFactor - 0.1f;

					if (textFactor > 0.5) {
						mHandler.sendEmptyMessage(1);
					}

				}

			} else if (mListView.getLastVisiblePosition() == mFloors.size() + 2) {
				isB = true;
				if (isA) {
					return;
				}

				if (tagSize < maxFontSize) {
					tagSize = tagSize + 1;
					shopsSize = shopsSize + 1;
					mListView.setAdapter(mAdapter);
					mHandler.sendEmptyMessage(1);
				}

			}

			letterSize = tagSize * 2;
			numberSize = tagSize;
			mTitleTv.setTextSize(convertSpToPx((int) (tagSize * 2.5)));
			mListView.setAdapter(mAdapter);

		};

	};

	private int convertSpToPx(float sp) {

		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
				getResources().getDisplayMetrics());

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		itemLayout = R.layout.item_f4;
		headerLayout = R.layout.header_f4;

		View view = LayoutInflater.from(this).inflate(itemLayout, null, false);
		TextView shops = (TextView) view.findViewById(R.id.shops);
		TextView tag = (TextView) view.findViewById(R.id.tag);

		tagSize = tag.getTextSize();
		shopsSize = shops.getTextSize();

		mListView = (ListView) findViewById(R.id.list_view);
		mListView.setDivider(null);
		mListView.setPadding(60, 0, 60, 0);

		View header = LayoutInflater.from(this).inflate(headerLayout,
				mListView, false);
		mTitleTv = (TextView) header.findViewById(R.id.floor_name);
		View footer = LayoutInflater.from(this).inflate(R.layout.footer,
				mListView, false);
		View footer2 = LayoutInflater.from(this).inflate(R.layout.footer,
				mListView, false);
		mListView.addHeaderView(header);
		mListView.addFooterView(footer);
		mListView.addFooterView(footer2);

		Intent intent = getIntent();
		FloorData floorData = (FloorData) intent
				.getSerializableExtra(LoginActivity.FLOOR_INFO);
		currentFloorId = floorData.getData().getFloorID();
		mAdapter = new GuideAdapter();
		mAdapter.bindData(mFloors = floorData.getData().getList());
		mListView.setAdapter(mAdapter);
		mListView.post(new Runnable() {

			@Override
			public void run() {
				mHandler.sendEmptyMessage(1);
			}
		});

	}

	class GuideAdapter extends BaseAdapter {

		class ViewHolder {
			private FoolView mFloorName;
			private TextView mTag;
			private TextView mShops;

		}

		private ArrayList<FloorInfo> floors;

		public void bindData(ArrayList<FloorInfo> data) {
			floors = data;
		}

		@Override
		public int getCount() {
			return floors.size();
		}

		@Override
		public Object getItem(int position) {
			return floors.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder viewHolder = null;
			if (convertView == null) {

				convertView = LayoutInflater.from(parent.getContext()).inflate(
						itemLayout, parent, false);

				viewHolder = new ViewHolder();
				viewHolder.mFloorName = (FoolView) convertView
						.findViewById(R.id.floor_name);
				viewHolder.mShops = (TextView) convertView
						.findViewById(R.id.shops);
				viewHolder.mTag = (TextView) convertView.findViewById(R.id.tag);

				convertView.setTag(viewHolder);

			}

			FloorInfo floor = floors.get(position);
			viewHolder = (ViewHolder) convertView.getTag();
			viewHolder.mFloorName.setText(floor.getFloor());
			viewHolder.mFloorName
					.setFloorLetterSize(convertSpToPx((int) letterSize * 2));
			viewHolder.mFloorName
					.setFloorNumberSize(convertSpToPx((int) (numberSize * 1.5)));
			viewHolder.mShops.setText(Html.fromHtml(floor.getInfo()));
			viewHolder.mShops.setTextSize(convertSpToPx(shopsSize));
			viewHolder.mShops.setLineSpacing(1, textFactor);

			if (floor.getTag() == null || floor.getTag().isEmpty()) {

				viewHolder.mTag.setVisibility(View.GONE);

			} else {
				viewHolder.mTag.setVisibility(View.VISIBLE);
				viewHolder.mTag.setText(floor.getTag());
				viewHolder.mTag.setTextSize(convertSpToPx(tagSize));
			}

			if (currentFloorId.equals(floor.getFloorID())) {

				viewHolder.mTag.setTextColor(Color.YELLOW);
				viewHolder.mShops.setTextColor(Color.YELLOW);
				viewHolder.mFloorName.setFloorLetterColor(Color.YELLOW);
				viewHolder.mFloorName.setFloorNumberColor(Color.YELLOW);

			} else {
				viewHolder.mTag.setTextColor(Color.WHITE);
				viewHolder.mShops.setTextColor(Color.WHITE);
				viewHolder.mFloorName.setFloorLetterColor(Color.WHITE);
				viewHolder.mFloorName.setFloorNumberColor(Color.WHITE);
			}

			return convertView;
		}

	}

}

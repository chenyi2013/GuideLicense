package com.puji.guidelicense;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.puji.guidelicense.bean.FloorData;
import com.puji.guidelicense.bean.FloorInfo;
import com.puji.guidelicense.view.FoolView;

public class MainActivity extends Activity {

	private ListView mListView;
	private GuideAdapter mAdapter;
	private RelativeLayout mLayout;

	private int flag;
	private int itemLayout;
	private int headerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mLayout = (RelativeLayout) findViewById(R.id.main_layout);

		Intent intent = getIntent();
		FloorData floorData = (FloorData) intent
				.getSerializableExtra(LoginActivity.FLOOR_INFO);

		flag = DataSource.FLOOR_4;
		updateLayout(flag);

		mListView = (ListView) findViewById(R.id.list_view);
		mListView.setDivider(null);
		mAdapter = new GuideAdapter();
		mAdapter.bindData(floorData.getData().getList());
		View header = LayoutInflater.from(this).inflate(headerLayout,
				mListView, false);
		mListView.addHeaderView(header);
		mListView.setAdapter(mAdapter);

	}

	private void updateLayout(int flag) {

		switch (flag) {
		case DataSource.FLOOR_5:
			itemLayout = R.layout.item_f5;
			headerLayout = R.layout.header_f5;

			break;

		case DataSource.FLOOR_11:
			itemLayout = R.layout.item_f11;
			headerLayout = R.layout.header_f11;
			break;
		case DataSource.FLOOR_11_2:
			itemLayout = R.layout.item_f11_2;
			headerLayout = R.layout.header_f11_2;
			break;
		case DataSource.FLOOR_5_2:
			itemLayout = R.layout.item_f5_2;
			headerLayout = R.layout.header_f5_2;
			break;
		case DataSource.FLOOR_4:
			itemLayout = R.layout.item_f4;
			headerLayout = R.layout.header_f4;
			break;
		case DataSource.FLOOR_6:
			itemLayout = R.layout.item_f6;
			headerLayout = R.layout.header_f6;
			mLayout.setPadding(60, 0, 60, 0);
			break;
		}

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
			viewHolder.mShops.setText(Html.fromHtml(floor.getInfo()));
			viewHolder.mTag.setText(floor.getTag());

			return convertView;
		}

	}

}

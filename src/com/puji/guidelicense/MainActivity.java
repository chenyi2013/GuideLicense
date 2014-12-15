package com.puji.guidelicense;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	ListView mListView;
	GuideAdapter mAdapter;
	ArrayList<Floor> mFloors;
	int flag;
	int itemLayout;
	int headerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		flag = DataSource.FLOOR_4;

		switch (flag) {
		case DataSource.FLOOR_5:
			itemLayout = R.layout.item_f5;
			headerLayout = R.layout.header_f5;
			mFloors = DataSource.getF5Data();

			break;

		case DataSource.FLOOR_11:
			itemLayout = R.layout.item_f11;
			headerLayout = R.layout.header_f11;
			mFloors = DataSource.getF11Data();
			break;
		case DataSource.FLOOR_11_2:
			itemLayout = R.layout.item_f11_2;
			headerLayout = R.layout.header_f11_2;
			mFloors = DataSource.getF11_2Data();
			break;
		case DataSource.FLOOR_5_2:
			itemLayout = R.layout.item_f5_2;
			headerLayout = R.layout.header_f5_2;
			mFloors = DataSource.getF5_2Data();
			break;
		case DataSource.FLOOR_4:
			itemLayout = R.layout.item_f4;
			headerLayout = R.layout.header_f4;
			mFloors = DataSource.getF4Data();
			break;
		}

		mListView = (ListView) findViewById(R.id.list_view);
		mListView.setDivider(null);
		mAdapter = new GuideAdapter();
		mAdapter.bindData(mFloors);
		View header = LayoutInflater.from(this).inflate(headerLayout,
				mListView, false);
		mListView.addHeaderView(header);
		mListView.setAdapter(mAdapter);

	}

	class GuideAdapter extends BaseAdapter {

		class ViewHolder {
			private FoolView mFloorName;
			private TextView mTag;
			private TextView mShops;

		}

		private ArrayList<Floor> floors;

		public void bindData(ArrayList<Floor> data) {
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

			Floor floor = floors.get(position);
			viewHolder = (ViewHolder) convertView.getTag();
			viewHolder.mFloorName.setText(floor.getFloorName());
			viewHolder.mShops.setText(floor.getShops());
			viewHolder.mTag.setText(floor.getTag());

			return convertView;
		}

	}

}

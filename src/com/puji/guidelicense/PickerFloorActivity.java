package com.puji.guidelicense;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.puji.guidelicense.bean.FloorData;
import com.puji.guidelicense.bean.FloorInfo;
import com.puji.guidelicense.util.SharePreferenceHelper;

public class PickerFloorActivity extends Activity implements OnClickListener {

	public static final String CURRENT_FLOOR = "current_floor";

	private Spinner mSpinner;
	private Button mOkButton;
	private ArrayList<FloorInfo> mFloors;
	private String mCurrentFloor;
	private FloorData mData;
	private SharePreferenceHelper mHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_picker_floor);
		mSpinner = (Spinner) findViewById(R.id.picker_floor);
		mHelper = new SharePreferenceHelper(this);
		mOkButton = (Button) findViewById(R.id.ok);
		mOkButton.setOnClickListener(this);

		Intent intent = getIntent();
		mData = (FloorData) intent
				.getSerializableExtra(LoginActivity.FLOOR_INFO);
		if (mData != null && mData.getData() != null) {
			mFloors = mData.getData().getList();
			PickerAdapter adapter = new PickerAdapter();
			adapter.bindData(mFloors);
			mSpinner.setAdapter(adapter);
		}

	}

	class PickerAdapter extends BaseAdapter {

		private ArrayList<FloorInfo> floors = new ArrayList<FloorInfo>();

		public void bindData(ArrayList<FloorInfo> floors) {
			if (floors != null) {
				this.floors = floors;
			}
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

			if (convertView == null) {
				convertView = LayoutInflater.from(parent.getContext()).inflate(
						android.R.layout.simple_spinner_item, parent, false);
			}
			((TextView) convertView).setText(floors.get(position).getFloor());
			return convertView;
		}

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.ok:
			FloorInfo info = (FloorInfo) mSpinner.getSelectedItem();
			if (info != null) {
				mCurrentFloor = info.getFloor();
				if (mCurrentFloor != null && !mCurrentFloor.isEmpty()
						&& mHelper.getAccount() != null
						&& !mHelper.getAccount().isEmpty()) {

					Intent intent = new Intent(PickerFloorActivity.this,
							MainActivity.class);
					intent.putExtra(LoginActivity.FLOOR_INFO, mData);
					mHelper.saveCurrentFloor(mHelper.getAccount(),
							mCurrentFloor);
					startActivity(intent);
					finish();

				}
			}
			break;

		default:
			break;
		}

	}

}

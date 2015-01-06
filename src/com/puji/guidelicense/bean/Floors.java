package com.puji.guidelicense.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class Floors implements Serializable{

	private static final long serialVersionUID = 2084252490491711592L;
	private ArrayList<FloorInfo> list;
	private String FloorID;
	private String FloorName;

	public ArrayList<FloorInfo> getList() {
		return list;
	}

	public void setList(ArrayList<FloorInfo> list) {
		this.list = list;
	}

	public String getFloorID() {
		return FloorID;
	}

	public void setFloorID(String floorID) {
		FloorID = floorID;
	}

	public String getFloorName() {
		return FloorName;
	}

	public void setFloorName(String floorName) {
		FloorName = floorName;
	}

	@Override
	public String toString() {
		return "Floors [list=" + list + ", FloorID=" + FloorID + ", FloorName="
				+ FloorName + "]";
	}

}

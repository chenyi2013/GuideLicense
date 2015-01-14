package com.puji.guidelicense.bean;

import java.io.Serializable;

public class FloorInfo implements Serializable {

	private static final long serialVersionUID = 5925948623140386583L;

	private String FloorID;
	private String Floor;
	private String Tag;
	private String Info;

	public String getFloorID() {
		return FloorID;
	}

	public void setFloorID(String floorID) {
		FloorID = floorID;
	}

	public String getFloor() {
		return Floor;
	}

	public void setFloor(String floor) {
		Floor = floor;
	}

	public String getTag() {
		return Tag;
	}

	public void setTag(String tag) {
		Tag = tag;
	}

	public String getInfo() {
		return Info;
	}

	public void setInfo(String info) {
		Info = info;
	}

	@Override
	public String toString() {
		return "FloorInfo [FloorID=" + FloorID + ", Floor=" + Floor + ", Tag="
				+ Tag + ", Info=" + Info + "]";
	}

}

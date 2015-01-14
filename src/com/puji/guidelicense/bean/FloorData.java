package com.puji.guidelicense.bean;

import java.io.Serializable;

public class FloorData implements Serializable{

	private static final long serialVersionUID = -8678300983496141469L;
	private Floors Data;
	private int Status;
	private String Msg;

	public Floors getData() {
		return Data;
	}

	public void setData(Floors data) {
		Data = data;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

	@Override
	public String toString() {
		return "FloorData [Data=" + Data + ", Status=" + Status + ", Msg="
				+ Msg + "]";
	}

}

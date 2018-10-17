package com.lt5.dishcollocation.util;

/**
 * @program:com.lt5.foodmanage.util
 * @description:
 * @class:Msg
 * @author:SanCheng
 * @create:2018-10-16
 **/
public class Msg {
	private int status;
	private String errorTip;
	private String dataBody;

	public Msg(int status, String errorTip, String dataBody) {
		this.status = status;
		this.errorTip = errorTip;
		this.dataBody = dataBody;
	}

	public Msg() {
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrorTip() {
		return errorTip;
	}

	public void setErrorTip(String errorTip) {
		this.errorTip = errorTip;
	}

	public String getDataBody() {
		return dataBody;
	}

	public void setDataBody(String dataBody) {
		this.dataBody = dataBody;
	}
}

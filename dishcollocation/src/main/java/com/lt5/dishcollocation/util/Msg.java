package com.lt5.dishcollocation.util;

import org.springframework.stereotype.Component;

/**
 * @program:com.lt5.foodmanage.util
 * @description:
 * @class:Msg
 * @author:SanCheng
 * @create:2018-10-16
 **/
@Component
public class Msg {
	private int status;
	private String errorTip;
	private String imformation;

	public Msg(int status, String errorTip, String imformation) {
		this.status = status;
		this.errorTip = errorTip;
		this.imformation = imformation;
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

	public String getimformation() {
		return imformation;
	}

	public void setimformation(String imformation) {
		this.imformation = imformation;
	}
}

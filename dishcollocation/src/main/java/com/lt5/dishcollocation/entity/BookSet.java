package com.lt5.dishcollocation.entity;

import java.util.Date;

/**
 * @program:com.lt5.dishcollocation.entity
 * @description:
 * @class:MenuSetting
 * @author:SanCheng
 * @create:2018-10-17
 **/
public class BookSet {
	private int storeId;
	private int days;
	private Date settingTime;

	public BookSet(int storeId, int days, Date settingTime) {
		this.storeId = storeId;
		this.days = days;
		this.settingTime = settingTime;
	}

	public BookSet() {
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Date getSettingTime() {
		return settingTime;
	}

	public void setSettingTime(Date settingTime) {
		this.settingTime = settingTime;
	}
}

package com.lt5.dishcollocation.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program:com.lt5.dishcollocation.entity
 * @description:
 * @class:dateMenu
 * @author:SanCheng
 * @create:2018-10-17
 **/
public class DateMenu {
	private int dishId;
	private Date dishDate;
	private String mealType;
	private int dishPrice;
	private int dishAmount;
	private int storeId;
	private String isSevenDay;

	public DateMenu(int dishId, Date dishDate, String mealType, int dishPrice, int dishAmount, int storeId, String isSevenDay) {
		this.dishId = dishId;
		this.dishDate = dishDate;
		this.mealType = mealType;
		this.dishPrice = dishPrice;
		this.dishAmount = dishAmount;
		this.storeId = storeId;
		this.isSevenDay = isSevenDay;
	}

	public DateMenu() {
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public Date getDishDate() {
		return dishDate;
	}

	public void setDishDate(Date dishDate) {
		this.dishDate = dishDate;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public int getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(int dishPrice) {
		this.dishPrice = dishPrice;
	}

	public int getDishAmount() {
		return dishAmount;
	}

	public void setDishAmount(int dishAmount) {
		this.dishAmount = dishAmount;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getIsSevenDay() {
		return isSevenDay;
	}

	public void setIsSevenDay(String isSevenDay) {
		this.isSevenDay = isSevenDay;
	}
}

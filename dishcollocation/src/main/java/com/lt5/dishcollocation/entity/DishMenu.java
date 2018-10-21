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
public class DishMenu {
	private int dishId;
	private Date dishDate;
	private int dishPrice;
	private int dishAmount;
	private int storeId;
	private String mealType;

	public DishMenu(int dishId, Date dishDate, int dishPrice, int dishAmount, int storeId, String mealType) {
		this.dishId = dishId;
		this.dishDate = dishDate;
		this.dishPrice = dishPrice;
		this.dishAmount = dishAmount;
		this.storeId = storeId;
		this.mealType = mealType;
	}

	public DishMenu() {

	}
	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
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

}

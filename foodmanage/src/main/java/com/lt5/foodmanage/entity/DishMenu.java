package com.lt5.foodmanage.entity;

/**
 * @program:com.lt5.foodmanage.entity
 * @description:
 * @class:DishMenu
 * @author:SanCheng
 * @create:2018-10-16
 **/
public class DishMenu {
	private int dishId;
	private String dishName;
	private int dishPrice;
	private String dishImage;
	private String cuisine;
	private int storeId;
	private int newDishId;

	public DishMenu(int dishId, String dishName, int dishPrice, String dishImage, String cuisine, int storeId, int newDishId) {
		this.dishId = dishId;
		this.dishName = dishName;
		this.dishPrice = dishPrice;
		this.dishImage = dishImage;
		this.cuisine = cuisine;
		this.storeId = storeId;
		this.newDishId = newDishId;
	}

	public DishMenu(int dishId, String dishName, int dishPrice, String dishImage, String cuisine, int storeId) {
		this.dishId = dishId;
		this.dishName = dishName;
		this.dishPrice = dishPrice;
		this.dishImage = dishImage;
		this.cuisine = cuisine;
		this.storeId = storeId;
	}

	public DishMenu(String dishName, int dishPrice, String cuisine, int storeId) {
		this.dishName = dishName;
		this.dishPrice = dishPrice;
		this.cuisine = cuisine;
		this.storeId = storeId;
	}

	public DishMenu(int dishId, int storeId) {
		this.dishId = dishId;
		this.storeId = storeId;
	}

	public DishMenu() {
	}

	public int getNewDishId() {
		return newDishId;
	}

	public void setNewDishId(int newDishId) {
		this.newDishId = newDishId;
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public int getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(int dishPrice) {
		this.dishPrice = dishPrice;
	}

	public String getDishImage() {
		return dishImage;
	}

	public void setDishImage(String dishImage) {
		this.dishImage = dishImage;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
}

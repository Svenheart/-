package com.lt5.dishcollocation.entity;

import java.util.ArrayList;

/**
 * @program:com.lt5.dishcollocation.entity
 * @description:
 * @class:TypeMenu
 * @author:SanCheng
 * @create:2018-10-21
 **/
public class TypeMenu {
	private String mealType;
	private ArrayList<DishMenu> dishMenus;

	public TypeMenu(String mealType, ArrayList<DishMenu> dishMenus) {
		this.mealType = mealType;
		this.dishMenus = dishMenus;
	}

	public TypeMenu() {
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public ArrayList<DishMenu> getDishMenus() {
		return dishMenus;
	}

	public void setDishMenus(ArrayList<DishMenu> dishMenus) {
		this.dishMenus = dishMenus;
	}
}

package com.lt5.foodmanage.service;

import com.lt5.foodmanage.entity.DishMenu;
import com.lt5.foodmanage.util.Msg;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @program:com.lt5.foodmanage.service
 * @description:
 * @class:DishManageService
 * @author:SanCheng
 * @create:2018-10-16
 **/
public interface DishManageService {
	Msg addDish(DishMenu dishMenu);
	Msg deleteSomeDish(ArrayList<DishMenu> dishMenu);
	Msg deleteDish(DishMenu dishMenu);
	Msg listDish(int storeId,int pageNum,int pageSize);
	Msg listSomeDish(int storeId,String condition,int pageNum,int pageSize);
	Msg updateDish(DishMenu dishMenu);
}

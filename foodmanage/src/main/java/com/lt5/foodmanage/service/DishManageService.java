package com.lt5.foodmanage.service;

import com.lt5.foodmanage.entity.DishMenu;
import com.lt5.foodmanage.util.Msg;

/**
 * @program:com.lt5.foodmanage.service
 * @description:
 * @class:DishManageService
 * @author:SanCheng
 * @create:2018-10-16
 **/
public interface DishManageService {
	Msg addDish(DishMenu dishMenu);
	Msg deleteDish(DishMenu dishMenu);
	Msg queryDish(int storeId );
	Msg updateDish(DishMenu dishMenu);
}

package com.lt5.dishcollocation.service;

import com.lt5.dishcollocation.entity.DateMenu;
import com.lt5.dishcollocation.entity.MenuSet;
import com.lt5.dishcollocation.util.Msg;

import java.util.ArrayList;

/**
 * @program:com.lt5.dishcollocation.service
 * @description:
 * @class:DishCollocationService
 * @author:SanCheng
 * @create:2018-10-17
 **/
public interface DishCollocationService {
	Msg addNewMenu(ArrayList<DateMenu> dateMenu);
	Msg setMenuDays(MenuSet menuSet);
	Msg getMenuDate(int storeId);
}
